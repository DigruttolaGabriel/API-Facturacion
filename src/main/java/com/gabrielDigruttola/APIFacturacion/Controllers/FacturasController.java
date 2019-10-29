package com.gabrielDigruttola.APIFacturacion.Controllers;

import com.gabrielDigruttola.APIFacturacion.Mappers.FacturaMapper;
import com.gabrielDigruttola.APIFacturacion.Models.Factura;
import com.gabrielDigruttola.APIFacturacion.Models.Usuario;
import com.gabrielDigruttola.APIFacturacion.Responses.FacturaResponse;
import com.gabrielDigruttola.APIFacturacion.Services.FacturaService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/facturas")
public class FacturasController {

    @Autowired
    private FacturaService facturaService;

    @RequestMapping(value = "/getFacturas/porFecha", method = RequestMethod.GET)
    public ResponseEntity obtenerFacturasPorFecha(@RequestParam(name = "mes") int mes, @RequestParam(name = "anio") int anio) {
        JSONObject json = new JSONObject();
        List<Factura> facturas;
        String resultado = "";

        try {
            facturas = facturaService.getFacturasPorMesYAnio(mes, anio);
        } catch (Exception e) {
            resultado = e.getMessage();
            json.put("mensaje", resultado);
            return new ResponseEntity<>(json, HttpStatus.CONFLICT);
        }

        List<FacturaResponse> response = new ArrayList<>();
        for (Factura factura : facturas) {
            FacturaResponse facturaResponse = FacturaMapper.toFacturaResponse(factura);
            //facturaResponse.setUsuarioResponse();
            response.add(facturaResponse);
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/getFacturas/porUsuario", method = RequestMethod.GET)
    public ResponseEntity obtenerFacturasPorUsuario(@RequestParam(name = "idUsuario") long idUsuario) {
        JSONObject json = new JSONObject();
        List<Factura> facturas;
        String resultado = "";

        try {
            facturas = facturaService.getFacturasPorUsuario(new Usuario(idUsuario));
        } catch (Exception e) {
            resultado = e.getMessage();
            json.put("mensaje", resultado);
            return new ResponseEntity<>(json, HttpStatus.CONFLICT);
        }

        List<FacturaResponse> response = new ArrayList<>();
        for (Factura factura : facturas) {
            response.add(FacturaMapper.toFacturaResponse(factura));
        }

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
