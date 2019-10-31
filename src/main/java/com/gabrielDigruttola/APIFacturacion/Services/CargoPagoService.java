package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Models.CargoPago;

public interface CargoPagoService {

    void guardarCargoPago(CargoPago cargoPago);

    double getSumaTotalPagadoPorUsuario(long idUsuario);
}
