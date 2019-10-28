package com.gabrielDigruttola.APIFacturacion.Mappers;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.gabrielDigruttola.APIFacturacion.Enums.Enums;
import com.gabrielDigruttola.APIFacturacion.Enums.Enums.Moneda;
import com.gabrielDigruttola.APIFacturacion.Enums.Enums.TipoEvento;
import com.gabrielDigruttola.APIFacturacion.Models.Cargo;
import com.gabrielDigruttola.APIFacturacion.Models.Evento;

import java.util.Date;

public class CargoMapper {
    @JsonProperty("event_type")
    private TipoEvento tipoEvento;

    @JsonProperty("user_id")
    private long idUsuario;

    @JsonProperty("amount")
    private double monto;

    @JsonProperty("currency")
    private Moneda moneda;

    @JsonProperty("date")
    private Date fecha;

    public static Cargo toPagoModel(CargoMapper cargoMapper) {
        Cargo cargo = new Cargo();
        cargo.setTotalCargo(cargoMapper.getMonto());
        cargo.setFechaCargo(cargoMapper.getFecha());
        cargo.setEstado(Enums.EstadoCargo.PENDIENTE_DE_PAGO.getValue());
        cargo.setEventoCargo(new Evento(cargoMapper.tipoEvento.getValue()));

        return cargo;
    }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
