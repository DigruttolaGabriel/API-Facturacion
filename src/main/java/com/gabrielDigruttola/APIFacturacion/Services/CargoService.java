package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Mappers.CargoMapper;
import com.gabrielDigruttola.APIFacturacion.Models.Cargo;

import java.util.List;

public interface CargoService {

    void guardarCargo(Cargo cargo);

    void procesarCargo(CargoMapper cargoMapper) throws Exception;

    double getDeudaTotal(List<Cargo> cargos);

    double getDeudaCargo(Cargo cargo);

    List<Cargo> getCargosAPagar(int estado, long idUsuario);

}
