package com.gabrielDigruttola.APIFacturacion.Repositories;

import com.gabrielDigruttola.APIFacturacion.Models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    @Query("SELECT f FROM Factura f WHERE EXTRACT(year FROM f.fechaFactura) = :anio AND EXTRACT(month FROM f.fechaFactura) = :mes")
    Factura findFacturaActual(@Param("anio") int anio, @Param("mes") int mes);

}
