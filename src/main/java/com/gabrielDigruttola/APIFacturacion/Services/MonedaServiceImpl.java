package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Models.Moneda;
import com.gabrielDigruttola.APIFacturacion.Repositories.MonedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MonedaServiceImpl implements MonedaService {

    @Autowired
    private MonedaRepository monedaRepository;

    @Override
    public Optional<Moneda> getMonedaPorId(int idMoneda) {
        return monedaRepository.findById(idMoneda);
    }
}
