package com.gabrielDigruttola.APIFacturacion.Responses;

import java.util.Date;

public class PagoResponse {

    private long idPago;
    private double monto;
    private Date fechaPago;

    public PagoResponse() {
    }

    public PagoResponse(long idPago, double monto, Date fechaPago) {
        this.idPago = idPago;
        this.monto = monto;
        this.fechaPago = fechaPago;
    }

    public long getIdPago() {
        return idPago;
    }

    public void setIdPago(long idPago) {
        this.idPago = idPago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }
}
