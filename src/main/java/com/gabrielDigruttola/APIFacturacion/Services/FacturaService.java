package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Models.Factura;

import java.util.Date;

public interface FacturaService {

    void guardarFactura(Factura factura);

    Factura getFacturaPorMesYAnio(Date fecha, long idUsuario);
}
