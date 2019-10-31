package com.gabrielDigruttola.APIFacturacion.ServicesTests;

import com.gabrielDigruttola.APIFacturacion.Enums.Enums;
import com.gabrielDigruttola.APIFacturacion.Models.Moneda;
import com.gabrielDigruttola.APIFacturacion.Services.MonedaService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class MonedaServiceTests {

    @Autowired
    private MonedaService monedaService;

    @Test
    public void getMonedaDolar_Test() {
        Enums.Moneda tipoMoneda = Enums.Moneda.USD;

        Optional<Moneda> resultado = monedaService.getMonedaPorId(tipoMoneda.getId());
        Moneda promise = new Moneda();
        promise.setNombreMoneda("Dólar");

        Assert.assertEquals(promise.getNombreMoneda(), resultado.get().getNombreMoneda());
    }

    @Test
    public void getMonedaErronea_Test() {
        Enums.Moneda tipoMoneda = Enums.Moneda.INDEFINIDO;

        Optional<Moneda> resultado = monedaService.getMonedaPorId(tipoMoneda.getId());

        Assert.assertEquals(false, resultado.isPresent());
    }
}
