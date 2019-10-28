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
    public ResponseEntity obtenerEstadoUsuario(@RequestParam(name = "idUsuario") long idUsuario) {
        JSONObject json = new JSONObject();
        return new ResponseEntity<JSONObject>(json, HttpStatus.OK);
    }
}
