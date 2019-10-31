package com.gabrielDigruttola.APIFacturacion.Mappers;

import com.gabrielDigruttola.APIFacturacion.Models.Cargo;
import com.gabrielDigruttola.APIFacturacion.Models.CargoPago;
import com.gabrielDigruttola.APIFacturacion.Models.Factura;
import com.gabrielDigruttola.APIFacturacion.Models.Usuario;
import com.gabrielDigruttola.APIFacturacion.Responses.UsuarioResponse;

import java.util.List;

public class UsuarioMapper {

    public static UsuarioResponse toUsuarioResponse(Usuario usuario) {
        UsuarioResponse usuarioResponse = new UsuarioResponse(
                usuario.getIdUsuario(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEmail(),
                0,
                0
        );

        return usuarioResponse;
    }

    public static UsuarioResponse toUsuarioResponse(Usuario usuario, double totalFacturado, double totalDeuda) {
        UsuarioResponse usuarioResponse = new UsuarioResponse(
                usuario.getIdUsuario(),
                usuario.getNombre(),
                usuario.getApellido(),
                usuario.getEmail(),
                totalFacturado,
                totalDeuda
        );

        return usuarioResponse;
    }
}
