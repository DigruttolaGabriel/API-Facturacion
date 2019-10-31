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

        double totalPagado = cargoPagoService.getSumaTotalPagadoPorUsuario(2);
        double totalPagadoPromise = 2700F;

        Assert.assertEquals(totalPagado, totalPagadoPromise, 0);
    }

}
