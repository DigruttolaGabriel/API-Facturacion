package com.gabrielDigruttola.APIFacturacion.Mappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabrielDigruttola.APIFacturacion.Enums.Enums.Moneda;
import com.gabrielDigruttola.APIFacturacion.Models.Pago;

public class PagoMapper {
    @JsonProperty("user_id")
    private long idUsuario;

    @JsonProperty("amount")
    private double monto;

    @JsonProperty("currency")
    private Moneda moneda;

    public static Pago toPagoModel(PagoMapper pagoMapper) {
        Pago pago = new Pago();
        pago.setMontoPago(pagoMapper.monto);
        return pago;
    }

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
}
