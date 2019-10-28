package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Enums.Enums.Moneda;
import com.gabrielDigruttola.APIFacturacion.Mappers.CargoMapper;
import com.gabrielDigruttola.APIFacturacion.Models.Cargo;
import com.gabrielDigruttola.APIFacturacion.Models.Pago;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CargoService {

    double calcularTotal(double monto, Moneda moneda) throws Exception;

    void guardarCargo(Cargo cargo);

    void procesarCargo(CargoMapper cargoMapper) throws Exception;

    List<Cargo> getCargosAPagar(int estado);

    double getDeudaTotal(List<Cargo> cargos);

    void asociarPago(Pago pago) throws Exception;
}
