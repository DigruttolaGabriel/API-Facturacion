package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Models.Evento;

import java.util.Optional;

public interface EventoService {

    void guardarEvento(Evento evento);

    Optional<Evento> getEventoPorId(int idEvento);
}
