package com.gabrielDigruttola.APIFacturacion.Repositories;

import com.gabrielDigruttola.APIFacturacion.Models.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {

}
