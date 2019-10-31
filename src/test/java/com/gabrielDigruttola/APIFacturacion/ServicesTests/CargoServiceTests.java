package com.gabrielDigruttola.APIFacturacion.ServicesTests;

import com.gabrielDigruttola.APIFacturacion.Enums.Enums;
import com.gabrielDigruttola.APIFacturacion.Mappers.CargoMapper;
import com.gabrielDigruttola.APIFacturacion.Models.Cargo;
import com.gabrielDigruttola.APIFacturacion.Models.CargoPago;
import com.gabrielDigruttola.APIFacturacion.Services.CargoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class CargoServiceTests {

    @Autowired
    private CargoService cargoService;

    @Test
    public void procesarCargoEventoErroneo_Test() throws Exception {
        CargoMapper cargoMapper = new CargoMapper();
        cargoMapper.setTipoEvento(Enums.TipoEvento.INDEFINIDO);

        String resultado = cargoService.procesarCargo(cargoMapper);
        String promise = "El evento no existe.";

        Assert.assertEquals(resultado, promise);
    }

    @Test
    public void procesarCargoUsuarioErroneo_Test() throws Exception {
        CargoMapper cargoMapper = new CargoMapper();
        cargoMapper.setTipoEvento(Enums.TipoEvento.CLASIFICADO);
        cargoMapper.setIdUsuario(666);

        String resultado = cargoService.procesarCargo(cargoMapper);
        String promise = "El usuario no existe.";

        Assert.assertEquals(resultado, promise);
    }

    @Test
    public void procesarCargoExitoso_Test() throws Exception {
        CargoMapper cargoMapper = new CargoMapper();
        cargoMapper.setTipoEvento(Enums.TipoEvento.CLASIFICADO);
        cargoMapper.setIdUsuario(3);
        cargoMapper.setMonto(500d);
        cargoMapper.setFecha(new Date());
        cargoMapper.setMoneda(Enums.Moneda.ARS);

        String resultado = cargoService.procesarCargo(cargoMapper);
        String promise = "Se agregó un nuevo cargo al usuario test@test.com.";

        Assert.assertEquals(resultado, promise);
    }

    @Test
    public void getDeudaTotal_Test() throws Exception {
        List<Cargo> cargos = new ArrayList<>();
        Cargo cargo = new Cargo();
        cargo.setTotalCargo(350d);
        CargoPago cargoPago = new CargoPago();
        cargoPago.setMontoAsociado(250d);
        cargo.getCargoPagoList().add(cargoPago);

        Cargo cargo2 = new Cargo();
        cargo2.setTotalCargo(250d);
        CargoPago cargoPago2 = new CargoPago();
        cargoPago2.setMontoAsociado(100d);
        cargo2.getCargoPagoList().add(cargoPago2);

        cargos.add(cargo);
        cargos.add(cargo2);

        double resultado = cargoService.getDeudaTotal(cargos);
        double promise = 250d;

        Assert.assertEquals(resultado, promise, 0);
    }

    @Test
    public void getDeudaCargo_Test() throws Exception {
        Cargo cargo = new Cargo();
        cargo.setTotalCargo(500d);

        CargoPago cargoPago = new CargoPago();
        cargoPago.setMontoAsociado(250d);
        cargo.getCargoPagoList().add(cargoPago);

        CargoPago cargoPago2 = new CargoPago();
        cargoPago2.setMontoAsociado(100d);
        cargo.getCargoPagoList().add(cargoPago2);

        double resultado = cargoService.getDeudaCargo(cargo);
        double promise = 150d;

        Assert.assertEquals(resultado, promise, 0);
    }

    @Test
    public void getCargosPendientesDeUsuario_Test() throws Exception {
        List<Cargo> resultado = cargoService.getCargosPorEstadoYUsuario(Enums.EstadoCargo.PENDIENTE_DE_PAGO.getId(), 1);
        int promise = 2;

        Assert.assertEquals(resultado.size(), promise);
    }

    @Test
    public void getCargosPagosDeUsuario_Test() throws Exception {
        List<Cargo> resultado = cargoService.getCargosPorEstadoYUsuario(Enums.EstadoCargo.PAGADO.getId(), 1);
        int promise = 2;

        Assert.assertEquals(resultado.size(), promise);
    }

    @Test
    public void getCargosDeUsuario_Test() throws Exception {
        List<Cargo> resultado = cargoService.getCargosPorUsuario(1);
        int promise = 4;

        Assert.assertEquals(resultado.size(), promise);
    }

    @Test
    public void getSumaTotalFacturadoDeUsuario_Test() throws Exception {
        double resultado = cargoService.getSumaTotalFacturadoPorUsuario(1);
        double promise = 3700d;

        Assert.assertEquals(resultado, promise, 0);
    }
}
