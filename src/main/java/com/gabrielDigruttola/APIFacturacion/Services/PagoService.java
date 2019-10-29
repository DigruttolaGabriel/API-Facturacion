package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Mappers.PagoMapper;

public interface PagoService {

    String procesarPago(PagoMapper pagoMapper) throws Exception;
}
