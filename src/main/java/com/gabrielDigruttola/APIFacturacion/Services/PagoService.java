package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Mappers.PagoMapper;

public interface PagoService {

    void procesarPago(PagoMapper pagoMapper) throws Exception;
}
