package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Mappers.PagoMapper;
import com.gabrielDigruttola.APIFacturacion.Models.Pago;

import java.util.List;

public interface PagoService {

    String procesarPago(PagoMapper pagoMapper) throws Exception;

    List<Pago> getPagosPorUsuario(long idUsuario);
}
