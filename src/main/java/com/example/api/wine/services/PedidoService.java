package com.example.api.wine.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.example.api.wine.dtos.PedidoCadastroDTO;
import com.example.api.wine.dtos.PedidoListagemDTO;
import com.example.api.wine.entities.Pedido;
import com.example.api.wine.entities.Usuario;
import com.example.api.wine.repositories.PedidoRepository;
import com.example.api.wine.repositories.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Transactional
    public void criarPedido(PedidoCadastroDTO pedidoDTO) {
        Long usuarioId = pedidoDTO.usuario().id();
        Usuario usuario = usuarioRepository.findById(usuarioId)
                           .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        
        Pedido pedido = new Pedido(pedidoDTO, usuario);
        pedidoRepository.save(pedido);
    }

    public Page<PedidoListagemDTO> listarPedidos(@PageableDefault(size = 10, sort = {"dataPedido"})Pageable paginacao){
        return pedidoRepository.findAll(paginacao).map(PedidoListagemDTO::new);
    }
}

