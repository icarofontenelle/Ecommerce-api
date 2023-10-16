package com.example.api.wine.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.api.wine.dtos.produtoDTO.ProdutoAtualizarDTO;
import com.example.api.wine.dtos.produtoDTO.ProdutoCadastroDTO;
import com.example.api.wine.dtos.produtoDTO.ProdutoListagemDTO;
import com.example.api.wine.services.ProdutoService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("produto")
@SecurityRequirement(name = "bearer-key")
public class ProdutoController {
    
    @Autowired
    private ProdutoService produtoService;
    
    @PostMapping
    public ResponseEntity <ProdutoListagemDTO> registrarProduto(@RequestBody @Valid ProdutoCadastroDTO dados_produto, UriComponentsBuilder uriBuilder){
        
        var produtoCriado = produtoService.criarProduto(dados_produto);
        var uri = uriBuilder.path("/produto/{id}").buildAndExpand(produtoCriado.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProdutoListagemDTO(produtoCriado));
    }
    
    @GetMapping
    public ResponseEntity <Page<ProdutoListagemDTO>> listarProdutos(@PageableDefault(size = 10, sort = "nome") Pageable paginacao){
        var page = produtoService.listarProdutos(paginacao); 
        return ResponseEntity.ok(page);
    }
    
    @PutMapping
    public ResponseEntity <ProdutoListagemDTO> atualizarProduto(@RequestBody @Valid ProdutoAtualizarDTO dados_produto){
       var produto = produtoService.atualizarProduto(dados_produto);
       return ResponseEntity.ok(new ProdutoListagemDTO(produto));
    }


    
}
