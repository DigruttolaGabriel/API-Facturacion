package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Models.Evento;
import com.gabrielDigruttola.APIFacturacion.Repositories.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoServiceImpl implements EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    @Override
    public void guardarEvento(Evento evento) {
        eventoRepository.save(evento);
    }

    @Override
    public Evento getEventoPorId(int idEvento) {
        return eventoRepository.getOne(idEvento);
    }
}
