package com.gabrielDigruttola.APIFacturacion.ServicesTests;

import com.gabrielDigruttola.APIFacturacion.Models.Factura;
import com.gabrielDigruttola.APIFacturacion.Models.Usuario;
import com.gabrielDigruttola.APIFacturacion.Services.FacturaService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class FacturaServiceTests {

    @Autowired
    private FacturaService facturaService;

    @Test
    public void getFacturaActual_Test() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, 10);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        Date fecha = calendar.getTime();

        Factura resultado = facturaService.getFacturaActual(fecha, 1);
        Factura promise = new Factura();
        promise.setIdFactura(1);

        Assert.assertEquals(promise.getIdFactura(), resultado.getIdFactura());
    }

    @Test
    public void getFacturaPorMesYAnio_Test() {
        int anio = 2017;
        int mes = 12;

        List<Factura> resultado = facturaService.getFacturasPorMesYAnio(mes, anio);

        Assert.assertEquals(2, resultado.size());
    }

    @Test
    public void getFacturaPorUsuario_Test() {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(1);

        List<Factura> resultado = facturaService.getFacturasPorUsuario(usuario);

        Assert.assertEquals(2, resultado.size());
    }
}
