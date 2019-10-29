package com.gabrielDigruttola.APIFacturacion.Repositories;

import com.gabrielDigruttola.APIFacturacion.Models.Factura;
import com.gabrielDigruttola.APIFacturacion.Models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    @Query("SELECT f FROM Factura f INNER JOIN Usuario u ON f.usuario.idUsuario = u.idUsuario WHERE EXTRACT(year FROM f.fechaFactura) = :anio AND EXTRACT(month FROM f.fechaFactura) = :mes AND u.idUsuario = :idUsuario")
    Factura findFacturaActual(@Param("mes") int mes, @Param("anio") int anio, @Param("idUsuario") long idUsuario);

    @Query("SELECT f FROM Factura f WHERE EXTRACT(year FROM f.fechaFactura) = :anio AND EXTRACT(month FROM f.fechaFactura) = :mes")
    List<Factura> findFacturasPorMesYAnio(@Param("mes") int mes, @Param("anio") int anio);

    List<Factura> findByUsuario(Usuario usuario);

}
