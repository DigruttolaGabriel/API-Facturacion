package com.gabrielDigruttola.APIFacturacion.Mappers;

import com.gabrielDigruttola.APIFacturacion.Enums.Enums;
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
        double total = 0;
        for (Cargo cargo : cargos) {
            total += cargo.getTotalCargo();
        }

        return total;
    }

    private static double calcularDeudaFactura(List<Cargo> cargos) {
        double totalFactura = calcularTotalFactura(cargos);
        double totalDeuda = 0;
        for (Cargo cargo : cargos) {
            totalDeuda += getDeudaCargo(cargo);
        }

        return totalFactura - totalDeuda;
    }

    private static double getDeudaCargo(Cargo cargo) {
        if (cargo.getEstado() == Enums.EstadoCargo.PAGADO.getId())
            return cargo.getTotalCargo();
        else {
            double deuda = cargo.getTotalCargo();
            for (CargoPago cargoPago : cargo.getCargoPagoList()) {
                deuda -= cargoPago.getPago().getMontoPago();
            }

            return deuda;
        }
    }
}
