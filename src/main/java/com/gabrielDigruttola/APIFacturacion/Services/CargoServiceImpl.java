package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Enums.Enums;
import com.gabrielDigruttola.APIFacturacion.Mappers.CargoMapper;
import com.gabrielDigruttola.APIFacturacion.Models.*;
import com.gabrielDigruttola.APIFacturacion.Repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private MonedaService monedaService;

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private EventoService eventoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CargoPagoService cargoPagoService;

    @Override
    public double calcularTotal(double monto, Enums.Moneda moneda) throws Exception {
        Optional<Moneda> monedaConversion = monedaService.getMonedaPorId(moneda.getValue());
        if (monedaConversion.isPresent())
            return monto * monedaConversion.get().getValorMoneda();
        else
            throw new Exception("La moneda no existe.");
    }

    @Override
    public void guardarCargo(Cargo cargo) {
        cargoRepository.save(cargo);
    }

    @Override
    public void procesarCargo(CargoMapper cargoMapper) throws Exception {
        try {
            Optional<Evento> evento = eventoService.getEventoPorId(cargoMapper.getTipoEvento().getValue());
            if (!evento.isPresent())
                throw new Exception("El evento no existe.");

            Optional<Usuario> usuario = usuarioService.getUsuarioPorId(cargoMapper.getIdUsuario());
            if (!usuario.isPresent())
                throw new Exception("El usuario no existe.");

            if (!cargoMapper.getMoneda().equals(Enums.Moneda.ARS))
                cargoMapper.setMonto(calcularTotal(cargoMapper.getMonto(), cargoMapper.getMoneda()));

            Factura factura = facturaService.getFacturaPorMesYAnio(cargoMapper.getFecha());
            if (factura == null)
                factura = new Factura(cargoMapper.getFecha(), usuario.get());

            Cargo cargo = CargoMapper.toPagoModel(cargoMapper);
            cargo.setFacturaCargo(factura);
            guardarCargo(cargo);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public double getDeudaTotal(List<Cargo> cargos) {
        double totalDeuda = 0;
        for (Cargo cargo : cargos) {
            double totalCargo = cargo.getTotalCargo();
            for (CargoPago cargoPago : cargo.getCargoPagoList()) {
                totalCargo -= cargoPago.getPago().getMontoPago();
            }
            totalDeuda += totalCargo;
        }

        return totalDeuda;
    }

    private double getDeudaCargo(Cargo cargo) {
        double deuda = cargo.getTotalCargo();
        for (CargoPago cargoPago : cargo.getCargoPagoList()) {
            deuda -= cargoPago.getPago().getMontoPago();
        }

        return deuda;
    }

    @Override
    public void asociarPago(Pago pago) throws Exception {
        //List<Cargo> cargos = cargoRepository.findByEstadoOrderByIdCargoAsc(Enums.EstadoCargo.PENDIENTE_DE_PAGO.getValue());
        List<Cargo> cargos = cargoRepository.findCargosPendientesPorUsuario(Enums.EstadoCargo.PENDIENTE_DE_PAGO.getValue(), 1);
        double totalPago = pago.getMontoPago();
        double totalDeuda = getDeudaTotal(cargos);
        if (totalPago <= totalDeuda && totalPago > 0) {
            while (totalPago > 0) {
                Cargo cargo = cargos.get(0);
                double deudaCargo = getDeudaCargo(cargo);

                CargoPago cargoPago = new CargoPago();
                cargoPago.setCargo(cargo);
                cargoPago.setPago(pago);
                cargoPagoService.guardarCargoPago(cargoPago);

                if (deudaCargo <= totalPago) {
                    cargo.setEstado(Enums.EstadoCargo.PAGADO.getValue());
                    guardarCargo(cargo);
                    cargos.remove(cargo);
                }
                totalPago -= deudaCargo;
            }
        } else {
            throw new Exception("El pago no puede superar la deuda del usuario.");
        }
    }

    @Override
    public List<Cargo> getCargosAPagar(int estado) {
        List<Cargo> cargos = cargoRepository.findByEstadoOrderByIdCargoAsc(Enums.EstadoCargo.PENDIENTE_DE_PAGO.getValue());

        return cargos;
    }

}
