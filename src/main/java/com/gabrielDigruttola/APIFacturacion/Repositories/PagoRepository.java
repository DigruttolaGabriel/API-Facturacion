package com.gabrielDigruttola.APIFacturacion.Repositories;

import com.gabrielDigruttola.APIFacturacion.Models.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

    @Query("SELECT DISTINCT p FROM Pago p " +
            "INNER JOIN CargoPago cp ON p.idPago = cp.pago.idPago " +
            "INNER JOIN Cargo c ON cp.cargo.idCargo = c.idCargo " +
            "INNER JOIN Factura f ON c.facturaCargo.idFactura = f.idFactura " +
            "WHERE f.usuario.idUsuario = :idUsuario " +
            "ORDER BY p.idPago ASC")
    List<Pago> findPagosPorUsuario(@Param("idUsuario") long idUsuario);
}
