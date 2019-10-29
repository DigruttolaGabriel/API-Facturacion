package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Enums.Enums;
import com.gabrielDigruttola.APIFacturacion.Mappers.PagoMapper;
import com.gabrielDigruttola.APIFacturacion.Models.Cargo;
import com.gabrielDigruttola.APIFacturacion.Models.CargoPago;
import com.gabrielDigruttola.APIFacturacion.Models.Pago;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private CargoService cargoService;

    @Autowired
    private CargoPagoService cargoPagoService;

    @Autowired
    private CommonService commonService;

    @Override
    public String procesarPago(PagoMapper pagoMapper) throws Exception {
        try {
            List<Cargo> cargos = cargoService.getCargosAPagar(Enums.EstadoCargo.PENDIENTE_DE_PAGO.getValue(), pagoMapper.getIdUsuario());

            if (pagoMapper.getMonto() > 0) {
                if (!pagoMapper.getMoneda().equals(Enums.Moneda.ARS))
                    pagoMapper.setMonto(commonService.calcularConversionMoneda(pagoMapper.getMonto(), pagoMapper.getMoneda()));

                double totalPago = pagoMapper.getMonto();
                double totalDeuda = cargoService.getDeudaTotal(cargos);
                if (totalPago <= totalDeuda) {
                    Pago pago = PagoMapper.toPagoModel(pagoMapper);
                    while (totalPago > 0) {
                        Cargo cargo = cargos.get(0);
                        double deudaCargo = cargoService.getDeudaCargo(cargo);

                        CargoPago cargoPago = new CargoPago();
                        cargoPago.setCargo(cargo);
                        cargoPago.setPago(pago);
                        cargoPagoService.guardarCargoPago(cargoPago);

                        if (deudaCargo <= totalPago) {
                            cargo.setEstado(Enums.EstadoCargo.PAGADO.getValue());
                            cargoService.guardarCargo(cargo);
                            cargos.remove(cargo);
                        }
                        totalPago -= deudaCargo;
                    }
                } else
                    return "El pago no puede superar la deuda del usuario.";
            } else
                return "El pago debe ser mayor que 0.";

            return "El pago se procesó exitósamente.";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
