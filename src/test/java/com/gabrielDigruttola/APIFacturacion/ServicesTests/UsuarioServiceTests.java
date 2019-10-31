package com.gabrielDigruttola.APIFacturacion.ServicesTests;

import com.gabrielDigruttola.APIFacturacion.Models.Usuario;
import com.gabrielDigruttola.APIFacturacion.Services.UsuarioService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class UsuarioServiceTests {

    @Autowired
    private UsuarioService usuarioService;

    @Test
    public void getUsuarioPorId_Test() {
        Optional<Usuario> resultado = usuarioService.getUsuarioPorId(1);
        String promise = "Mario";

        Assert.assertEquals(promise, resultado.get().getNombre());
    }

    @Test
    public void getUsuarioPorIdErroneo_Test() {
        Optional<Usuario> resultado = usuarioService.getUsuarioPorId(666);

        Assert.assertEquals(false, resultado.isPresent());
    }

    @Test
    public void getDeudaUsuario_Test() {
        double totalFacturado = 1500d;
        double totalPagado = 1000d;

        double resultado = usuarioService.getDeudaUsuario(totalFacturado, totalPagado);
        double promise = 500d;

        Assert.assertEquals(promise, resultado, 0);
    }
}
