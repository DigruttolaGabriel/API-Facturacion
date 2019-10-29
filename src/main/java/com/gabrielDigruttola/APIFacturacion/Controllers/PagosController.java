package com.gabrielDigruttola.APIFacturacion.Controllers;

import com.gabrielDigruttola.APIFacturacion.Mappers.PagoMapper;
import com.gabrielDigruttola.APIFacturacion.Models.Cargo;
import com.gabrielDigruttola.APIFacturacion.Models.Pago;
import com.gabrielDigruttola.APIFacturacion.Services.CargoService;
import com.gabrielDigruttola.APIFacturacion.Services.PagoService;
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
    private PagoService pagoService;

    @RequestMapping(value = "/generarPago", method = RequestMethod.POST)
    public ResponseEntity generarPago(@RequestBody PagoMapper pagoMapper) {
        JSONObject json = new JSONObject();
        String resultado = "";
        HttpStatus httpStatus = HttpStatus.OK;

        try {
            resultado = pagoService.procesarPago(pagoMapper);
        } catch (Exception e) {
            resultado = e.getMessage();
            httpStatus = HttpStatus.CONFLICT;
        }

        json.put("mensaje", resultado);
        return new ResponseEntity<>(json, httpStatus);
    }

    @RequestMapping(value = "/getPagos", method = RequestMethod.GET)
    public ResponseEntity obtenerPagos(@RequestParam(name = "idUsuario") long idUsuario) {
        JSONObject json = new JSONObject();
        return new ResponseEntity<>(json, HttpStatus.OK);
    }
}
