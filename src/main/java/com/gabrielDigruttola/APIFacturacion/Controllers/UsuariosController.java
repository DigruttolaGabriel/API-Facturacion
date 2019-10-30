package com.gabrielDigruttola.APIFacturacion.Controllers;

import net.minidev.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @RequestMapping(value = "/getEstadoUsuario", method = RequestMethod.GET)
    public ResponseEntity obtenerEstadoUsuarioPorId(@RequestParam(name = "idUsuario") long idUsuario) {
        JSONObject json = new JSONObject();
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @RequestMapping(value = "/getEstadoUsuario", method = RequestMethod.GET)
    public ResponseEntity obtenerEstadoUsuarioPorEmail(@RequestParam(name = "email") String email) {
        JSONObject json = new JSONObject();
        return new ResponseEntity<>(json, HttpStatus.OK);
    }
}
