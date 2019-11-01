package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Enums.Enums;
import com.gabrielDigruttola.APIFacturacion.Mappers.PagoMapper;
import com.gabrielDigruttola.APIFacturacion.Models.Cargo;
import com.gabrielDigruttola.APIFacturacion.Models.CargoPago;
import com.gabrielDigruttola.APIFacturacion.Models.Pago;
import com.gabrielDigruttola.APIFacturacion.Models.Usuario;
import com.gabrielDigruttola.APIFacturacion.Repositories.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoServiceImpl implements PagoService {

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private CargoPagoService cargoPagoService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public String procesarPago(PagoMapper pagoMapper) throws Exception {
        try {
            List<Cargo> cargos = cargoService.getCargosPorEstadoYUsuario(Enums.EstadoCargo.PENDIENTE_DE_PAGO.getId(), pagoMapper.getIdUsuario());

            if (pagoMapper.getMonto() > 0) {
                Optional<Usuario> usuario = usuarioService.getUsuarioPorId(pagoMapper.getIdUsuario());
                if (usuario.isPresent()) {
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

                            if (deudaCargo <= totalPago) {
                                cargoPago.setMontoAsociado(deudaCargo);
                                cargo.setEstado(Enums.EstadoCargo.PAGADO.getId());
                                cargoService.guardarCargo(cargo);
                                cargos.remove(cargo);
                            } else
                                cargoPago.setMontoAsociado(totalPago);

                            cargoPago.setCargo(cargo);
                            cargoPago.setPago(pago);
                            cargoPagoService.guardarCargoPago(cargoPago);
                            totalPago -= deudaCargo;
                        }
                    } else
                        return "El pago no puede superar la deuda del usuario.";
                } else
                    return "El usuario no existe.";
            } else
                return "El pago debe ser mayor que 0.";

            return "El pago se procesó exitósamente.";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public List<Pago> getPagosPorUsuario(long idUsuario) {
        return pagoRepository.findPagosPorUsuario(idUsuario);
    }
}
