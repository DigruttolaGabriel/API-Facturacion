package com.gabrielDigruttola.APIFacturacion.ServicesTests;

import com.gabrielDigruttola.APIFacturacion.Enums.Enums;
import com.gabrielDigruttola.APIFacturacion.Services.CommonService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class CommonServiceTests {

    @Autowired
    private CommonService commonService;

    @Test
    public void calcularConversionMonedaDolar_Test() throws Exception {
        double monto = 100;
        Enums.Moneda moneda = Enums.Moneda.USD;

        double resultado = commonService.calcularConversionMoneda(monto, moneda);
        double promise = 6000d;

        Assert.assertEquals(resultado, promise, 0);
    }

    @Test
    public void calcularConversionMonedaPesos_Test() throws Exception {
        double monto = 100;
        Enums.Moneda moneda = Enums.Moneda.ARS;

        double resultado = commonService.calcularConversionMoneda(monto, moneda);
        double promise = 100;

        Assert.assertEquals(resultado, promise, 0);
    }

    @Test
    public void calcularConversionMonedaErronea_Test() throws Exception {
        try {
            double monto = 100;
            Enums.Moneda moneda = Enums.Moneda.INDEFINIDO;

            commonService.calcularConversionMoneda(monto, moneda);
        } catch (Exception e) {
            String promise = "La moneda no existe.";
            Assert.assertEquals(e.getMessage(), promise);
        }
    }

    @Test
    public void calcularRedondeo_Test() {
        double monto = 10.758d;

        double resultado = commonService.calcularRedondeoDosDecimales(monto);
        double promise = 10.76d;

        Assert.assertEquals(promise, resultado, 0);
    }

}
