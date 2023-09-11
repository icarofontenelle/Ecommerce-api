package com.example.api.wine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.wine.dtos.ItemPedidoCadastroDTO;
import com.example.api.wine.entities.ItemPedido;
import com.example.api.wine.entities.Pedido;
import com.example.api.wine.entities.Produto;
import com.example.api.wine.repositories.ItemPedidoRepository;
import com.example.api.wine.repositories.PedidoRepository;
import com.example.api.wine.repositories.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ItemPedidoService {
    
    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Transactional
    public void criarItemPedido(ItemPedidoCadastroDTO itemPedidoDTO) {
        Produto produto = produtoRepository.findById(itemPedidoDTO.produto().id())
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        Pedido pedido = pedidoRepository.findById(itemPedidoDTO.pedido().id())
            .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        ItemPedido itemPedido = new ItemPedido(itemPedidoDTO, pedido, produto);

        itemPedidoRepository.save(itemPedido);
    }
}
