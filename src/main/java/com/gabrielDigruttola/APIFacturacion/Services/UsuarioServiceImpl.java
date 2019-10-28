package com.gabrielDigruttola.APIFacturacion.Services;

import com.gabrielDigruttola.APIFacturacion.Models.Usuario;
import com.gabrielDigruttola.APIFacturacion.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> getUsuarioPorId(long idUsuario) {
        return usuarioRepository.findById(idUsuario);
    }
}
