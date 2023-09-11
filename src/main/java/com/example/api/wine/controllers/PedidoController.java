package com.example.api.wine.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.wine.dtos.PedidoCadastroDTO;
import com.example.api.wine.dtos.PedidoListagemDTO;
import com.example.api.wine.services.PedidoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("pedido")
public class PedidoController {
 
     @Autowired
    private PedidoService pedidoService;

    @PostMapping
    @Transactional
    public void registrarPedido(@RequestBody @Valid PedidoCadastroDTO dados_pedido) {
        pedidoService.criarPedido(dados_pedido);
    }

    @GetMapping
    public Page<PedidoListagemDTO> listarPedidos(){
      return pedidoService.listarPedidos(null);  
    }

}
