package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Enums.Enums;
import com.gabrielDigruttola.APIFacturacion.Mappers.CargoMapper;
import com.gabrielDigruttola.APIFacturacion.Models.*;
import com.gabrielDigruttola.APIFacturacion.Repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    private CommonService commonService;

    @Override
    public void guardarCargo(Cargo cargo) {
        cargoRepository.save(cargo);
    }

    @Override
    public String procesarCargo(CargoMapper cargoMapper) throws Exception {
        try {
            Optional<Evento> evento = eventoService.getEventoPorId(cargoMapper.getTipoEvento().getId());
            if (!evento.isPresent())
                return "El evento no existe.";

            Optional<Usuario> usuario = usuarioService.getUsuarioPorId(cargoMapper.getIdUsuario());
            if (!usuario.isPresent())
                return "El usuario no existe.";

            if (!cargoMapper.getMoneda().equals(Enums.Moneda.ARS))
                cargoMapper.setMonto(commonService.calcularConversionMoneda(cargoMapper.getMonto(), cargoMapper.getMoneda()));

            Factura factura = facturaService.getFacturaActual(new Date(), cargoMapper.getIdUsuario());
            if (factura == null)
                factura = new Factura(new Date(), usuario.get());

            Cargo cargo = CargoMapper.toCargoModel(cargoMapper);
            cargo.setFacturaCargo(factura);
            guardarCargo(cargo);

            return "Se agregó un nuevo cargo al usuario " + usuario.get().getEmail() + ".";
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
                totalCargo -= cargoPago.getMontoAsociado();
            }
            totalDeuda += totalCargo;
        }

        return totalDeuda;
    }

    @Override
    public double getDeudaCargo(Cargo cargo) {
        double deuda = cargo.getTotalCargo();
        for (CargoPago cargoPago : cargo.getCargoPagoList()) {
            deuda -= cargoPago.getMontoAsociado();
        }

        return deuda;
    }

    @Override
    public List<Cargo> getCargosPorEstadoYUsuario(int estado, long idUsuario) {
        return cargoRepository.findCargosPorEstadoYPorUsuario(estado, idUsuario);
    }

    @Override
    public List<Cargo> getCargosPorUsuario(long idUsuario) {
        return cargoRepository.findCargosPorUsuario(idUsuario);
    }

    @Override
    public double getSumaTotalFacturadoPorUsuario(long idUsuario) {
        return cargoRepository.sumTotalFacturadoPorUsuario(idUsuario);
    }

}
