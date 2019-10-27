package com.gabrielDigruttola.APIFacturacion.Repositories;

import com.gabrielDigruttola.APIFacturacion.Models.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

}
