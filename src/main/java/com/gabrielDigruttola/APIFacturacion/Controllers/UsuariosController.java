package com.gabrielDigruttola.APIFacturacion.Controllers;

import com.gabrielDigruttola.APIFacturacion.Mappers.UsuarioMapper;
import com.gabrielDigruttola.APIFacturacion.Models.Usuario;
import com.gabrielDigruttola.APIFacturacion.Responses.UsuarioResponse;
import com.gabrielDigruttola.APIFacturacion.Services.CargoPagoService;
import com.gabrielDigruttola.APIFacturacion.Services.CargoService;
import com.gabrielDigruttola.APIFacturacion.Services.UsuarioService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private CargoPagoService cargoPagoService;

    @RequestMapping(value = "/getEstadoUsuario", method = RequestMethod.GET)
    public ResponseEntity obtenerEstadoUsuarioPorId(@RequestParam(name = "idUsuario") long idUsuario) {
        JSONObject json = new JSONObject();
        UsuarioResponse usuarioResponse;

        try {
            Optional<Usuario> usuario = usuarioService.getUsuarioPorId(idUsuario);
            if (usuario.isPresent()) {
                double totalFacturado = cargoService.getSumaTotalFacturadoPorUsuario(idUsuario);
                double totalPagado = cargoPagoService.getSumaTotalPagadoPorUsuario(idUsuario);
                double totalDeuda = usuarioService.getDeudaUsuario(totalFacturado, totalPagado);

                usuarioResponse = UsuarioMapper.toUsuarioResponse(usuario.get(), totalFacturado, totalDeuda);
            } else
                throw new Exception("El usuario no existe.");
        } catch (Exception e) {
            String resultado = e.getMessage();
            json.put("mensaje", resultado);
            return new ResponseEntity<>(json, HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(usuarioResponse, HttpStatus.OK);
    }
}
