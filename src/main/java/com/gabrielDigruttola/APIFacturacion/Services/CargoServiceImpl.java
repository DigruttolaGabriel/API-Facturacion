package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Enums.Enums;
import com.gabrielDigruttola.APIFacturacion.Mappers.CargoMapper;
import com.gabrielDigruttola.APIFacturacion.Mappers.PagoMapper;
import com.gabrielDigruttola.APIFacturacion.Models.*;
import com.gabrielDigruttola.APIFacturacion.Repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private FacturaService facturaService;

    @Autowired
    private EventoService eventoService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CargoPagoService cargoPagoService;

    @Autowired
    private CommonService commonService;

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
                cargoMapper.setMonto(commonService.calcularConversionMoneda(cargoMapper.getMonto(), cargoMapper.getMoneda()));

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

    @Override
    public double getDeudaCargo(Cargo cargo) {
        double deuda = cargo.getTotalCargo();
        for (CargoPago cargoPago : cargo.getCargoPagoList()) {
            deuda -= cargoPago.getPago().getMontoPago();
        }

        return deuda;
    }

    @Override
    public List<Cargo> getCargosAPagar(int estado, long idUsuario) {
        List<Cargo> cargos = cargoRepository.findCargosPendientesPorUsuario(estado, idUsuario);
        return cargos;
    }

}
