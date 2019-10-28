package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Models.Usuario;

import java.util.Optional;

public interface UsuarioService {

    void guardarUsuario(Usuario usuario);

    Optional<Usuario> getUsuarioPorId(long idUsuario);
}
