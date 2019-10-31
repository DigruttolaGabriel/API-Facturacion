package com.gabrielDigruttola.APIFacturacion.Mappers;

import com.gabrielDigruttola.APIFacturacion.Models.Cargo;
import com.gabrielDigruttola.APIFacturacion.Models.CargoPago;
import com.gabrielDigruttola.APIFacturacion.Models.Factura;
import com.gabrielDigruttola.APIFacturacion.Models.Usuario;
import com.gabrielDigruttola.APIFacturacion.Responses.UsuarioResponse;

import java.util.List;

public class UsuarioMapper {

    public static UsuarioResponse toUsuarioResponse(Usuario usuario, double totalFacturado, double totalDeuda) {
        UsuarioResponse usuarioResponse = new UsuarioResponse(
                usuario.getIdUsuario(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEmail(),
                totalFacturado,
                totalDeuda
        );

        return usuarioResponse;
    }

    private static double calcularTotalFacturado(List<Factura> facturas) {
        double totalFacturado = 0;
        for (Factura factura : facturas) {
            for (Cargo cargo : factura.getCargoFacturaList()) {
                totalFacturado += cargo.getTotalCargo();
            }
        }

        return totalFacturado;
    }

    private static double calcularTotalDeuda(List<Factura> facturas) {
        double totalDeuda = 0;
        for (Factura factura : facturas) {
            for (Cargo cargo : factura.getCargoFacturaList()) {
                for (CargoPago cargoPago : cargo.getCargoPagoList()) {

                }
            }
        }
        return totalDeuda;
    }
}
