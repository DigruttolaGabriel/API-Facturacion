package com.gabrielDigruttola.APIFacturacion.Responses;

import com.gabrielDigruttola.APIFacturacion.Enums.Enums;

import java.util.Date;

public class CargoResponse {

    private long idCargo;
    private Date fechaCargo;
    private double total;
    private Enums.TipoEvento evento;
    private Enums.EstadoCargo estado;

    public CargoResponse() {
    }

    public CargoResponse(long idCargo, Date fechaCargo, double total, Enums.TipoEvento evento, Enums.EstadoCargo estado) {
        this.idCargo = idCargo;
        this.fechaCargo = fechaCargo;
        this.total = total;
        this.evento = evento;
        this.estado = estado;
    }

    public long getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(long idCargo) {
        this.idCargo = idCargo;
    }

    public Date getFechaCargo() {
        return fechaCargo;
    }

    public void setFechaCargo(Date fechaCargo) {
        this.fechaCargo = fechaCargo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Enums.TipoEvento getEvento() {
        return evento;
    }

    public void setEvento(Enums.TipoEvento evento) {
        this.evento = evento;
    }

    public Enums.EstadoCargo getEstado() {
        return estado;
    }

    public void setEstado(Enums.EstadoCargo estado) {
        this.estado = estado;
    }
}
