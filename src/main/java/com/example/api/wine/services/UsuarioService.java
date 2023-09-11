package com.example.api.wine.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.example.api.wine.dtos.UsuarioAtualizarDTO;
import com.example.api.wine.dtos.UsuarioCadastroDTO;
import com.example.api.wine.dtos.UsuarioListagemDTO;
import com.example.api.wine.entities.Usuario;
import com.example.api.wine.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public void criarUsuario(UsuarioCadastroDTO usuarioCadastroDTO){
        usuarioRepository.save(new Usuario(usuarioCadastroDTO));
    }

    public Page<UsuarioListagemDTO> listarUsuarios(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        return usuarioRepository.findAllByAtivoTrue(paginacao).map(UsuarioListagemDTO::new);
    }

    @Transactional
    public void atualizarUsuario(UsuarioAtualizarDTO usuarioAtualizarDTO){
        var usuario = usuarioRepository.getReferenceById(usuarioAtualizarDTO.id());
        usuario.atualizarInformacoes(usuarioAtualizarDTO);    
    }

    @Transactional
    public void excluirUsuario(Long id){
        var usuario = usuarioRepository.getReferenceById(id);
        usuario.excluirInformacoes();

    }
}
