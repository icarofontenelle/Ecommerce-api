package com.example.api.wine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.wine.dtos.ItemPedidoCadastroDTO;
import com.example.api.wine.services.ItemPedidoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("itempedido")
public class ItemPedidoController {
    
    @Autowired
    ItemPedidoService itemPedidoService;
    
    @PostMapping
    @Transactional
    public void registrarItemPedido(@RequestBody @Valid ItemPedidoCadastroDTO dados_ItemPedidoDTO){
        itemPedidoService.criarItemPedido(dados_ItemPedidoDTO);
    }
}
