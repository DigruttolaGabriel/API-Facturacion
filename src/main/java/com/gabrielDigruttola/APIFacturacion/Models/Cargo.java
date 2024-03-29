package com.gabrielDigruttola.APIFacturacion.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_cargo")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_cargo")
    private long idCargo;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCargo;

    @Column(name = "total", nullable = false, scale = 2)
    private double totalCargo;

    @Column(name = "estado", nullable = false)
    private int estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_evento", nullable = false)
    private Evento eventoCargo;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_factura", nullable = false)
    private Factura facturaCargo;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "cargo")
    private List<CargoPago> cargoPagoList;

    public Cargo() {
        this.cargoPagoList = new ArrayList<>();
        this.eventoCargo = new Evento();
        this.facturaCargo = new Factura();
    }

    public Cargo(long idCargo, Date fechaCargo, double totalCargo, int estado, Evento eventoCargo, Factura facturaCargo, List<CargoPago> cargoPagoList) {
        this.idCargo = idCargo;
        this.fechaCargo = fechaCargo;
        this.totalCargo = totalCargo;
        this.estado = estado;
        this.eventoCargo = eventoCargo;
        this.facturaCargo = facturaCargo;
        this.cargoPagoList = cargoPagoList;
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

    public double getTotalCargo() {
        return totalCargo;
    }

    public void setTotalCargo(double totalCargo) {
        this.totalCargo = totalCargo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Evento getEventoCargo() {
        return eventoCargo;
    }

    public void setEventoCargo(Evento eventoCargo) {
        this.eventoCargo = eventoCargo;
    }

    public Factura getFacturaCargo() {
        return facturaCargo;
    }

    public void setFacturaCargo(Factura facturaCargo) {
        this.facturaCargo = facturaCargo;
    }

    public List<CargoPago> getCargoPagoList() {
        return cargoPagoList;
    }

    public void setCargoPagoList(List<CargoPago> cargoPagoList) {
        this.cargoPagoList = cargoPagoList;
    }
}
