package com.gabrielDigruttola.APIFacturacion.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_usuario")
    private long idUsuario;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "apellido", length = 50, nullable = false)
    private String apellido;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "fecha_alta", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "usuario")
    private List<Factura> facturaUsuarioList;

    public Usuario() {
        this.facturaUsuarioList = new ArrayList<>();
    }

    public Usuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(long idUsuario, String nombre, String apellido, String email, Date fechaAlta, List<Factura> facturaUsuarioList) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaAlta = fechaAlta;
        this.facturaUsuarioList = facturaUsuarioList;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public List<Factura> getFacturaUsuarioList() {
        return facturaUsuarioList;
    }

    public void setFacturaUsuarioList(List<Factura> facturaUsuarioList) {
        this.facturaUsuarioList = facturaUsuarioList;
    }
}
