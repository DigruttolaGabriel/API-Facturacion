package com.gabrielDigruttola.APIFacturacion.Repositories;

import com.gabrielDigruttola.APIFacturacion.Models.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

    List<Cargo> findByEstadoOrderByIdCargoAsc(int estado);

    @Query("SELECT c from Cargo c INNER JOIN Factura f ON c.facturaCargo.idFactura = f.idFactura WHERE c.estado = :estado AND f.usuario.idUsuario = :idUsuario ORDER BY c.idCargo ASC")
    List<Cargo> findCargosPendientesPorUsuario(@Param("estado") int estado, @Param("idUsuario") long idUsuario);

    @Query("SELECT c from Cargo c INNER JOIN Factura f ON c.facturaCargo.idFactura = f.idFactura WHERE f.usuario.idUsuario = :idUsuario ORDER BY c.idCargo ASC")
    List<Cargo> findCargosPorUsuario(@Param("idUsuario") long idUsuario);

}
