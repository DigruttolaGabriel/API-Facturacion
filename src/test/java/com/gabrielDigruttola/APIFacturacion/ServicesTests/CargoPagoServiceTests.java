package com.gabrielDigruttola.APIFacturacion.ServicesTests;

import com.gabrielDigruttola.APIFacturacion.Services.CargoPagoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class CargoPagoServiceTests {

    @Autowired
    private CargoPagoService cargoPagoService;

    @Test
    public void getTotalPagadoPorUsuario_Test() {

        double resultado = cargoPagoService.getSumaTotalPagadoPorUsuario(1);
        double promise = 1000d;

        Assert.assertEquals(promise, resultado, 0);
    }

}
