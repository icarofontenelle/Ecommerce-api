package com.example.api.wine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

import com.example.api.wine.dtos.ProdutoCadastroDTO;
import com.example.api.wine.dtos.ProdutoListagemDTO;
import com.example.api.wine.entities.Produto;
import com.example.api.wine.repositories.ProdutoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public void criarProduto(ProdutoCadastroDTO produtoCadastroDTO){
        produtoRepository.save(new Produto(produtoCadastroDTO));
    }

    public Page<ProdutoListagemDTO> listarProdutos(@PageableDefault(size = 10, sort = {"nome"})Pageable paginacao){
        return produtoRepository.findAll(paginacao).map(ProdutoListagemDTO::new);
    }

    public void atualizarProduto(ProdutoCadastroDTO produtoAtualizarDTO){
        var produto = produtoRepository.getReferenceById(produtoAtualizarDTO.id());
        produto.atualizarInformacoes(produtoAtualizarDTO);
    }
}
