package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Enums.Enums.Moneda;
import com.gabrielDigruttola.APIFacturacion.Mappers.CargoMapper;
import com.gabrielDigruttola.APIFacturacion.Models.Cargo;

public interface CargoService {

    double calcularTotal(double monto, Moneda moneda) throws Exception;

    void guardarCargo(Cargo cargo);

    void procesarCargo(CargoMapper cargoMapper) throws Exception;
}
