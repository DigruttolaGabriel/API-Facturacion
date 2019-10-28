package com.gabrielDigruttola.APIFacturacion.Repositories;

import com.gabrielDigruttola.APIFacturacion.Models.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonedaRepository extends JpaRepository<Moneda, Integer> {
    Moneda findByIdMoneda(int idMoneda);
}
