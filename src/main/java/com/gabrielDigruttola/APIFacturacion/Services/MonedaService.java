package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Models.Moneda;

import java.util.Optional;

public interface MonedaService {

    Optional<Moneda> getMonedaPorId(int idMoneda);
}
