package com.gabrielDigruttola.APIFacturacion.Responses;

import com.gabrielDigruttola.APIFacturacion.Models.Usuario;

import java.util.Date;

public class FacturaResponse {

    private long idFactura;
    private Date fechaFactura;
    private double totalFactura;
    private double deudaFactura;
    private UsuarioResponse usuarioResponse;

    public FacturaResponse() {
    }

    public FacturaResponse(long idFactura, Date fechaFactura, double totalFactura, double deudaFactura) {
        this.idFactura = idFactura;
        this.fechaFactura = fechaFactura;
        this.totalFactura = totalFactura;
        this.deudaFactura = deudaFactura;
    }

    public FacturaResponse(long idFactura, Date fechaFactura, double totalFactura, double deudaFactura, UsuarioResponse usuarioResponse) {
        this.idFactura = idFactura;
        this.fechaFactura = fechaFactura;
        this.totalFactura = totalFactura;
        this.deudaFactura = deudaFactura;
        this.usuarioResponse = usuarioResponse;
    }

    public long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(long idFactura) {
        this.idFactura = idFactura;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public double getDeudaFactura() {
        return deudaFactura;
    }

    public void setDeudaFactura(double deudaFactura) {
        this.deudaFactura = deudaFactura;
    }

    public UsuarioResponse getUsuarioResponse() {
        return usuarioResponse;
    }

    public void setUsuarioResponse(UsuarioResponse usuarioResponse) {
        this.usuarioResponse = usuarioResponse;
    }
}
