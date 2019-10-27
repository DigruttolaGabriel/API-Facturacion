package com.gabrielDigruttola.APIFacturacion.Models;

import javax.persistence.*;

@Entity
@Table(name = "moneda")
public class Moneda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_moneda")
    private long idMoneda;

    @Column(name = "valor", nullable = false)
    private double valorMoneda;

    public Moneda(long idMoneda, double valorMoneda) {
        this.idMoneda = idMoneda;
        this.valorMoneda = valorMoneda;
    }

    public long getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(long idMoneda) {
        this.idMoneda = idMoneda;
    }

    public double getValorMoneda() {
        return valorMoneda;
    }

    public void setValorMoneda(double valorMoneda) {
        this.valorMoneda = valorMoneda;
    }
}
