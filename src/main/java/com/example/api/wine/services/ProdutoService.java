package com.example.api.wine.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.api.wine.dtos.produtoDTO.ProdutoAtualizarDTO;
import com.example.api.wine.dtos.produtoDTO.ProdutoCadastroDTO;
import com.example.api.wine.dtos.produtoDTO.ProdutoListagemDTO;
import com.example.api.wine.entities.Produto;
import com.example.api.wine.repositories.ProdutoRepository;
import com.example.api.wine.services.validacoes.produtoValidacoes.ValidadorProduto;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private List<ValidadorProduto> validadores;

    @Transactional
    public Produto criarProduto(ProdutoCadastroDTO produtoCadastroDTO){
        validadores.forEach(v -> v.validar(produtoCadastroDTO)); //Passando cada dado recebido no DTO por cada um dos validadores criados.
        return produtoRepository.save(new Produto(produtoCadastroDTO));
    }

    public Page<ProdutoListagemDTO> listarProdutos(Pageable paginacao){
        return produtoRepository.findAll(paginacao).map(ProdutoListagemDTO::new);
    }

    @Transactional
    public Produto atualizarProduto(@Valid ProdutoAtualizarDTO produtoAtualizarDTO){
        var produto = produtoRepository.getReferenceById(produtoAtualizarDTO.id());
        produto.atualizarInformacoes(produtoAtualizarDTO);
        return produto;
    }

    @Transactional
    public void excluirProduto(Long id){
        var produto = produtoRepository.getReferenceById(id);
        produto.excluirInformacoes();
    }

    
}
