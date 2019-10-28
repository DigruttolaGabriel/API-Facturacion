package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Models.CargoPago;
import com.gabrielDigruttola.APIFacturacion.Repositories.CargoPagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoPagoServiceImpl implements CargoPagoService {

    @Autowired
    private CargoPagoRepository cargoPagoRepository;

    @Override
    public void guardarCargoPago(CargoPago cargoPago) {
        cargoPagoRepository.save(cargoPago);
    }
}
