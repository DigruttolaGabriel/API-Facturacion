package com.gabrielDigruttola.APIFacturacion.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_factura")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_factura")
    private long idFactura;

    @Column(name = "fecha_facturacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFactura;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_usuario", nullable = false)
    private Usuario usuario;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "facturaCargo")
    private List<Cargo> cargoFacturaList;

    public Factura() {
        this.cargoFacturaList = new ArrayList<>();
        this.usuario = new Usuario();
    }

    public Factura(Date fechaFactura, Usuario usuario) {
        this.fechaFactura = fechaFactura;
        this.usuario = usuario;
    }

    public Factura(long idFactura, Date fechaFactura, Usuario usuario, List<Cargo> cargoFacturaList) {
        this.idFactura = idFactura;
        this.fechaFactura = fechaFactura;
        this.usuario = usuario;
        this.cargoFacturaList = cargoFacturaList;
    }

    public long getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(long idFactura) {
        this.idFactura = idFactura;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Date fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public List<Cargo> getCargoFacturaList() {
        return cargoFacturaList;
    }

    public void setCargoFacturaList(List<Cargo> cargoFacturaList) {
        this.cargoFacturaList = cargoFacturaList;
    }
}
