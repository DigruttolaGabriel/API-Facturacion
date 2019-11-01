package com.gabrielDigruttola.APIFacturacion.Repositories;

import com.gabrielDigruttola.APIFacturacion.Models.CargoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoPagoRepository extends JpaRepository<CargoPago, Long> {

    @Query("SELECT COALESCE(SUM(cp.montoAsociado), 0) FROM CargoPago cp " +
            "INNER JOIN Cargo c ON cp.cargo.idCargo = c.idCargo " +
            "INNER JOIN Factura f ON c.facturaCargo.idFactura = f.idFactura " +
            "INNER JOIN Usuario u ON f.usuario.idUsuario = u.idUsuario " +
            "WHERE u.idUsuario = :idUsuario")
    double sumTotalPagadoPorUsuario(@Param("idUsuario") long idUsuario);
}
