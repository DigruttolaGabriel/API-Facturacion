package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Enums.Enums;
import com.gabrielDigruttola.APIFacturacion.Models.Moneda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Optional;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private MonedaService monedaService;

    @Override
    public double calcularConversionMoneda(double monto, Enums.Moneda moneda) throws Exception {
        Optional<Moneda> monedaConversion = monedaService.getMonedaPorId(moneda.getId());
        if (monedaConversion.isPresent())
            return monto * monedaConversion.get().getValorMoneda();
        else
            throw new Exception("La moneda no existe.");
    }

    @Override
    public double calcularRedondeoDosDecimales(double monto) {
        DecimalFormat format = new DecimalFormat("#.##");

        return Double.valueOf(format.format(monto));
    }
}
