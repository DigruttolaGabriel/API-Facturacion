package com.gabrielDigruttola.APIFacturacion.ServicesTests;

import com.gabrielDigruttola.APIFacturacion.Enums.Enums;
import com.gabrielDigruttola.APIFacturacion.Models.Evento;
import com.gabrielDigruttola.APIFacturacion.Services.EventoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class EventoServiceTests {

    @Autowired
    private EventoService eventoService;

    @Test
    public void getEventoPorId_Test() {
        Enums.TipoEvento tipoEvento = Enums.TipoEvento.MERCADOPAGO;

        Optional<Evento> resultado = eventoService.getEventoPorId(tipoEvento.getId());
        Evento promise = new Evento(6, "MercagoPago");

        Assert.assertEquals(promise.getNombreEvento(), resultado.get().getNombreEvento());
    }
}
