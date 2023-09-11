package com.example.api.wine.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.wine.dtos.ProdutoCadastroDTO;
import com.example.api.wine.dtos.ProdutoListagemDTO;
import com.example.api.wine.services.ProdutoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("produto")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;
    
    @PostMapping
    @Transactional
    public void registrarProduto(@RequestBody @Valid ProdutoCadastroDTO dados_produto){
        produtoService.criarProduto(dados_produto);       
    }
    
    @GetMapping
    public Page<ProdutoListagemDTO> listarProdutos(){
        return produtoService.listarProdutos(null);
    }
    
    @PutMapping
    public void atualizarProduto(@RequestBody @Valid ProdutoCadastroDTO dados_produto){
        produtoService.atualizarProduto(dados_produto);
    }
    
}
