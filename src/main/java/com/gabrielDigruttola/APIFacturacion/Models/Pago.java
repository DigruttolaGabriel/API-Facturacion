package com.gabrielDigruttola.APIFacturacion.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_pago")
    private long idPago;

    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;

    @Column(name = "monto", nullable = false)
    private double montoPago;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pago")
    private List<CargoPago> cargoPagoList;

    public Pago() {
        this.cargoPagoList = new ArrayList<>();
    }

    public Pago(double montoPago) {
        this.montoPago = montoPago;
        this.fechaPago = new Date();
        this.cargoPagoList = new ArrayList<>();
    }

    public Pago(long idPago, Date fechaPago, double montoPago, List<CargoPago> cargoPagoList) {
        this.idPago = idPago;
        this.fechaPago = fechaPago;
        this.montoPago = montoPago;
        this.cargoPagoList = cargoPagoList;
    }

    public long getIdPago() {
        return idPago;
    }

    public void setIdPago(long idPago) {
        this.idPago = idPago;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public double getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(double montoPago) {
        this.montoPago = montoPago;
    }

    public List<CargoPago> getCargoPagoList() {
        return cargoPagoList;
    }

    public void setCargoPagoList(List<CargoPago> cargoPagoList) {
        this.cargoPagoList = cargoPagoList;
    }
}
