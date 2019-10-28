package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Enums.Enums;
import com.gabrielDigruttola.APIFacturacion.Mappers.CargoMapper;
import com.gabrielDigruttola.APIFacturacion.Models.*;
import com.gabrielDigruttola.APIFacturacion.Repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
