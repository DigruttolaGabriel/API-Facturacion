package com.gabrielDigruttola.APIFacturacion.Controllers;

import com.gabrielDigruttola.APIFacturacion.Models.Cargo;
import com.gabrielDigruttola.APIFacturacion.Models.Pago;
import com.gabrielDigruttola.APIFacturacion.Services.CargoService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/api/pagos")
public class PagosController {

    @Autowired
    private CargoService cargoService;

    @RequestMapping(value = "/generarPago", method = RequestMethod.POST)
    public ResponseEntity generarPago(@RequestBody Pago pago) {
        JSONObject json = new JSONObject();

        try {
            cargoService.asociarPago(pago);
        } catch (Exception e) {
            json.put("mensaje", e.getMessage());
        }

        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @RequestMapping(value = "/getPagos", method = RequestMethod.GET)
    public ResponseEntity obtenerPagos(@RequestParam(name = "idUsuario") long idUsuario) {
        JSONObject json = new JSONObject();
        return new ResponseEntity<>(json, HttpStatus.OK);
    }
}
