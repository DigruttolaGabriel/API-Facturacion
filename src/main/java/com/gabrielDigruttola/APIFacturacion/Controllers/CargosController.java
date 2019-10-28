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

        try {
            cargoService.procesarCargo(cargoMapper);
        } catch (Exception e) {
            json.put("mensaje", e.getMessage());
            return new ResponseEntity<>(json, HttpStatus.CONFLICT);
        }

        json.put("fecha", cargoMapper.getFecha());
        json.put("monto", cargoMapper.getMonto());
        json.put("moneda", cargoMapper.getMoneda());
        json.put("usuario", cargoMapper.getIdUsuario());
        json.put("evento", cargoMapper.getTipoEvento());
        json.put("monedaConvertida", Enums.Moneda.ARS.getValue());

        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @RequestMapping(value = "/getCargos", method = RequestMethod.GET)
    public ResponseEntity obtenerCargos(@RequestParam(name = "idUsuario") long idUsuario) {
        JSONObject json = new JSONObject();
        Cargo cargo;
        List<Cargo> cargos;
        double deuda;
        try {
            //cargo = cargoService.getCargosAPagar(Enums.EstadoCargo.PENDIENTE_DE_PAGO.getValue());
            cargos = cargoService.getCargosAPagar(Enums.EstadoCargo.PENDIENTE_DE_PAGO.getValue());
            deuda = cargoService.getDeudaTotal(cargos);
        } catch (Exception e) {
            json.put("mensaje", e.getMessage());
            return new ResponseEntity<>(json, HttpStatus.CONFLICT);
        }

        /*json.put("id", cargo.getIdCargo());
        json.put("usuario", cargo.getFacturaCargo().getUsuario().getNombre());
        json.put("monto", cargo.getTotalCargo());*/
        json.put("deuda", deuda);
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

}
