package com.gabrielDigruttola.APIFacturacion.Mappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabrielDigruttola.APIFacturacion.Enums.Enums.Moneda;
import com.gabrielDigruttola.APIFacturacion.Models.Pago;
import com.gabrielDigruttola.APIFacturacion.Responses.PagoResponse;

public class PagoMapper {
    @JsonProperty("user_id")
    private long idUsuario;

    @JsonProperty("amount")
    private double monto;

    @JsonProperty("currency")
    private Moneda moneda;

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public static Pago toPagoModel(PagoMapper pagoMapper) {
        return new Pago(pagoMapper.monto);
    }

    public static PagoResponse toPagoResponse(Pago pago) {
        PagoResponse pagoResponse = new PagoResponse(
                pago.getIdPago(),
                pago.getMontoPago(),
                pago.getFechaPago()
        );

        return pagoResponse;
    }
}
