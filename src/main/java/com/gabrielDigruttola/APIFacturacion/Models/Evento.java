package com.gabrielDigruttola.APIFacturacion.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_evento")
    private int idEvento;

    @Column(name = "nombre", nullable = false)
    private String nombreEvento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_categoria_evento", nullable = false)
    private CategoriaDeEvento categoriaDeEvento;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "eventoCargo")
    private List<Cargo> cargoEventoList;

    public Evento() {
        this.cargoEventoList = new ArrayList<>();
        this.categoriaDeEvento = new CategoriaDeEvento();
    }

    public Evento(int idEvento, String nombreEvento) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.cargoEventoList = new ArrayList<>();
        this.categoriaDeEvento = new CategoriaDeEvento();
    }

    public Evento(int idEvento) {
        this.idEvento = idEvento;
        this.cargoEventoList = new ArrayList<>();
        this.categoriaDeEvento = new CategoriaDeEvento();
    }

    public Evento(int idEvento, String nombreEvento, CategoriaDeEvento categoriaDeEvento, List<Cargo> cargoEventoList) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.categoriaDeEvento = categoriaDeEvento;
        this.cargoEventoList = cargoEventoList;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public CategoriaDeEvento getCategoriaDeEvento() {
        return categoriaDeEvento;
    }

    public void setCategoriaDeEvento(CategoriaDeEvento categoriaDeEvento) {
        this.categoriaDeEvento = categoriaDeEvento;
    }

    public List<Cargo> getCargoEventoList() {
        return cargoEventoList;
    }

    public void setCargoEventoList(List<Cargo> cargoEventoList) {
        this.cargoEventoList = cargoEventoList;
    }
}
