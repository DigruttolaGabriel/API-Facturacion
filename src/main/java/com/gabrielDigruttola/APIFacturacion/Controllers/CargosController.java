package com.gabrielDigruttola.APIFacturacion.Controllers;

import com.gabrielDigruttola.APIFacturacion.Enums.Enums;
import com.gabrielDigruttola.APIFacturacion.Mappers.CargoMapper;
import com.gabrielDigruttola.APIFacturacion.Models.Cargo;
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

import java.util.List;

@Controller
@RequestMapping("/api/cargos")
public class CargosController {

    @Autowired
    private CargoService cargoService;

    @RequestMapping(value = "/generarCargo", method = RequestMethod.POST)
    public ResponseEntity generarCargo(@RequestBody CargoMapper cargoMapper) {
        JSONObject json = new JSONObject();
        String resultado = "";
        HttpStatus httpStatus = HttpStatus.OK;

        try {
            resultado = cargoService.procesarCargo(cargoMapper);
        } catch (Exception e) {
            resultado = e.getMessage();
            httpStatus = HttpStatus.CONFLICT;
        }

        json.put("mensaje", resultado);
        return new ResponseEntity<>(json, httpStatus);
    }

    @RequestMapping(value = "/getCargos", method = RequestMethod.GET)
    public ResponseEntity obtenerCargos(@RequestParam(name = "idUsuario") long idUsuario) {
        JSONObject json = new JSONObject();
        List<Cargo> cargos;
        String resultado = "";
        try {
            cargos = cargoService.getCargosAPagar(Enums.EstadoCargo.PENDIENTE_DE_PAGO.getValue(), idUsuario);
        } catch (Exception e) {
            json.put("mensaje", e.getMessage());
            return new ResponseEntity<>(json, HttpStatus.CONFLICT);
        }

        json.put("mensaje", resultado);
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

}
