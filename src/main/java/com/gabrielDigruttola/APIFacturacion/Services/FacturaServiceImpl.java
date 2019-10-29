package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Models.Factura;
import com.gabrielDigruttola.APIFacturacion.Repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Override
    public void guardarFactura(Factura factura) {
        facturaRepository.save(factura);
    }

    @Override
    public Factura getFacturaPorMesYAnio(Date fecha, long idUsuario) {
        LocalDate localDate = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int anio = localDate.getYear();
        int mes = localDate.getMonthValue();

        return facturaRepository.findFacturaActual(anio, mes, idUsuario);
    }
}
