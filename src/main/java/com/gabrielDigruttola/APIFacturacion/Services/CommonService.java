package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Enums.Enums;

public interface CommonService {

    double calcularConversionMoneda(double monto, Enums.Moneda moneda) throws Exception;
}
