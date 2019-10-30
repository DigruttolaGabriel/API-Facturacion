package com.gabrielDigruttola.APIFacturacion.Mappers;

import com.gabrielDigruttola.APIFacturacion.Models.Cargo;
import com.gabrielDigruttola.APIFacturacion.Models.CargoPago;
import com.gabrielDigruttola.APIFacturacion.Models.Factura;
import com.gabrielDigruttola.APIFacturacion.Responses.FacturaResponse;

import java.util.List;

public class FacturaMapper {

    public static FacturaResponse toFacturaResponse(Factura factura) {
        FacturaResponse facturaResponse = new FacturaResponse(
                factura.getIdFactura(),
                factura.getFechaFactura(),
                calcularTotalFactura(factura.getCargoFacturaList()),
                calcularDeudaFactura(factura.getCargoFacturaList())
        );

        return facturaResponse;
    }

    private static double calcularTotalFactura(List<Cargo> cargos) {
        double totalFactura = 0;
        for (Cargo cargo : cargos) {
            totalFactura += cargo.getTotalCargo();
        }

        return totalFactura;
    }

    private static double calcularTotalPagado(List<Cargo> cargos) {
        double totalPagado = 0;
        for (Cargo cargo : cargos) {
            for (CargoPago cargoPago : cargo.getCargoPagoList()) {
                totalPagado += cargoPago.getMontoAsociado();
            }
        }

        return totalPagado;
    }

    private static double calcularDeudaFactura(List<Cargo> cargos) {
        double totalFactura = calcularTotalFactura(cargos);
        double totalDeuda = calcularTotalPagado(cargos);

        return totalFactura - totalDeuda;
    }
}
