package com.example.api.wine.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.api.wine.dtos.usuarioDTO.UsuarioAtualizarDTO;
import com.example.api.wine.dtos.usuarioDTO.UsuarioCadastroDTO;
import com.example.api.wine.dtos.usuarioDTO.UsuarioListagemDTO;
import com.example.api.wine.entities.Usuario;
import com.example.api.wine.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario criarUsuario(UsuarioCadastroDTO usuarioCadastroDTO){
        Usuario usuario = new Usuario(usuarioCadastroDTO);
        return usuarioRepository.save(usuario);
    }

    public Page<UsuarioListagemDTO> listarUsuarios(Pageable paginacao) {
        return usuarioRepository.findAllByAtivoTrue(paginacao).map(UsuarioListagemDTO::new);
    }
    
    @Transactional
    public Usuario atualizarUsuario(UsuarioAtualizarDTO usuarioAtualizarDTO){
        var usuario = usuarioRepository.getReferenceById(usuarioAtualizarDTO.id());
        usuario.atualizarInformacoes(usuarioAtualizarDTO);
        return usuario;
    }

    @Transactional
    public void excluirUsuario(Long id){
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.excluirInformacoes();
    }

    public Usuario detalharUsuario(Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
}
