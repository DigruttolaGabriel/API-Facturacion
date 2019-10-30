package com.gabrielDigruttola.APIFacturacion.Models;

import javax.persistence.*;

@Entity
@Table(name = "tb_cargo_pago")
public class CargoPago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_cargo_pago")
    private long idCargoPago;

    @Column(name = "monto_asociado", nullable = false, scale = 2)
    private double montoAsociado;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_cargo", nullable = false)
    private Cargo cargo;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_pago", nullable = false)
    private Pago pago;

    public CargoPago() {
        this.cargo = new Cargo();
        this.pago = new Pago();
    }

    public CargoPago(long idCargoPago, Cargo cargo, Pago pago, double montoAsociado) {
        this.idCargoPago = idCargoPago;
        this.cargo = cargo;
        this.pago = pago;
        this.montoAsociado = montoAsociado;
    }

    public long getIdCargoPago() {
        return idCargoPago;
    }

    public void setIdCargoPago(long idCargoPago) {
        this.idCargoPago = idCargoPago;
    }

    public double getMontoAsociado() {
        return montoAsociado;
    }

    public void setMontoAsociado(double montoAsociado) {
        this.montoAsociado = montoAsociado;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
}
