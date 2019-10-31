package com.gabrielDigruttola.APIFacturacion.ServicesTests;

import com.gabrielDigruttola.APIFacturacion.Enums.Enums;
import com.gabrielDigruttola.APIFacturacion.Mappers.PagoMapper;
import com.gabrielDigruttola.APIFacturacion.Models.Pago;
import com.gabrielDigruttola.APIFacturacion.Services.PagoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class PagoServiceTests {

    @Autowired
    private PagoService pagoService;

    @Test
    public void procesarPagoDeudaMenor_Test() throws Exception {
        PagoMapper pagoMapper = new PagoMapper();
        pagoMapper.setIdUsuario(1);
        pagoMapper.setMonto(50000000);
        pagoMapper.setMoneda(Enums.Moneda.ARS);

        String resultado = pagoService.procesarPago(pagoMapper);
        String promise = "El pago no puede superar la deuda del usuario.";

        Assert.assertEquals(promise, resultado);
    }

    @Test
    public void procesarPagoValorCero_Test() throws Exception {
        PagoMapper pagoMapper = new PagoMapper();
        pagoMapper.setIdUsuario(1);
        pagoMapper.setMonto(0);
        pagoMapper.setMoneda(Enums.Moneda.ARS);

        String resultado = pagoService.procesarPago(pagoMapper);
        String promise = "El pago debe ser mayor que 0.";

        Assert.assertEquals(promise, resultado);
    }

    @Test
    public void getPagosPorUsuario_Test() {
        List<Pago> resultado = pagoService.getPagosPorUsuario(1);

        Assert.assertEquals(2, resultado.size());
    }
}
