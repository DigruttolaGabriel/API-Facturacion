package com.gabrielDigruttola.APIFacturacion.Repositories;

import com.gabrielDigruttola.APIFacturacion.Models.CategoriaDeEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaDeEventoRepository extends JpaRepository<CategoriaDeEvento, Integer> {

}
