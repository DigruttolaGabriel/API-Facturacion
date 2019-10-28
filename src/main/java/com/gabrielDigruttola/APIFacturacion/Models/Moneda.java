package com.gabrielDigruttola.APIFacturacion.Models;

import javax.persistence.*;

@Entity
@Table(name = "moneda")
public class Moneda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_moneda")
    private int idMoneda;

    @Column(name = "nombre", nullable = false)
    private String nombreMoneda;

    @Column(name = "valor", nullable = false)
    private double valorMoneda;

    public Moneda() {

    }

    public Moneda(int idMoneda, String nombreMoneda, double valorMoneda) {
        this.idMoneda = idMoneda;
        this.nombreMoneda = nombreMoneda;
        this.valorMoneda = valorMoneda;
    }

    public long getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(int idMoneda) {
        this.idMoneda = idMoneda;
    }

    public String getNombreMoneda() {
        return nombreMoneda;
    }

    public void setNombreMoneda(String nombreMoneda) {
        this.nombreMoneda = nombreMoneda;
    }

    public double getValorMoneda() {
        return valorMoneda;
    }

    public void setValorMoneda(double valorMoneda) {
        this.valorMoneda = valorMoneda;
    }
}
