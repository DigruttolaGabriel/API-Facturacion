package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Models.Factura;
import com.gabrielDigruttola.APIFacturacion.Models.Usuario;

import java.util.Date;
import java.util.List;

public interface FacturaService {

    void guardarFactura(Factura factura);

    Factura getFacturaActual(Date fecha, long idUsuario);

    List<Factura> getFacturasPorMesYAnio(int mes, int anio);

    List<Factura> getFacturasPorUsuario(Usuario usuario);
}
