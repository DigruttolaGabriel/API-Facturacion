package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Models.Evento;

public interface EventoService {

    void guardarEvento(Evento evento);

    Evento getEventoPorId(int idEvento);
}
