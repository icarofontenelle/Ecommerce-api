package com.example.api.wine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.example.api.wine.dtos.NotaCadastroDTO;
import com.example.api.wine.dtos.NotaListagemDTO;
import com.example.api.wine.entities.Nota;
import com.example.api.wine.entities.Pedido;
import com.example.api.wine.repositories.NotaRepository;
import com.example.api.wine.repositories.PedidoRepository;


import jakarta.transaction.Transactional;

@Service
public class NotaService {
    
    @Autowired
    private NotaRepository notaRepository;

    @Autowired 
    private PedidoRepository pedidoRepository;


    @Transactional
    public void criarNota(NotaCadastroDTO notaDTO) {
        Long pedidoId = notaDTO.pedido().id();
        Pedido pedido = pedidoRepository.findById(pedidoId)
                            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        String clienteNome = pedido.getUsuario().getNome();
        
        Nota nota = new Nota(notaDTO, pedido);
        nota.setCliente(clienteNome);
        notaRepository.save(nota);                   
    }

    public Page<NotaListagemDTO> listarNotas(@PageableDefault(size = 10, sort = {"cliente"})Pageable paginacao){
        return notaRepository.findAll(paginacao).map(NotaListagemDTO::new);
    }
}
