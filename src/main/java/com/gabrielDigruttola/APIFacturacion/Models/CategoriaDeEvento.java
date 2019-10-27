package com.gabrielDigruttola.APIFacturacion.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categoria_evento")
public class CategoriaDeEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_categoria_evento")
    private int idCategoriaDeEvento;

    @Column(name = "nombre", nullable = false)
    private String nombreCategoriaDeEvento;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "categoriaDeEvento")
    private List<Evento> eventoCategoriaList;

    public CategoriaDeEvento() {
        this.eventoCategoriaList = new ArrayList<>();
    }

    public CategoriaDeEvento(int idCategoriaDeEvento, String nombreCategoriaDeEvento, List<Evento> eventoCategoriaList) {
        this.idCategoriaDeEvento = idCategoriaDeEvento;
        this.nombreCategoriaDeEvento = nombreCategoriaDeEvento;
        this.eventoCategoriaList = eventoCategoriaList;
    }

    public long getIdCategoriaDeEvento() {
        return idCategoriaDeEvento;
    }

    public void setIdCategoriaDeEvento(int idCategoriaDeEvento) {
        this.idCategoriaDeEvento = idCategoriaDeEvento;
    }

    public String getNombreCategoriaDeEvento() {
        return nombreCategoriaDeEvento;
    }

    public void setNombreCategoriaDeEvento(String nombreCategoriaDeEvento) {
        this.nombreCategoriaDeEvento = nombreCategoriaDeEvento;
    }

    public List<Evento> getEventoCategoriaList() {
        return eventoCategoriaList;
    }

    public void setEventoCategoriaList(List<Evento> eventoCategoriaList) {
        this.eventoCategoriaList = eventoCategoriaList;
    }
}
