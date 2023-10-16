package com.example.api.wine.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.api.wine.dtos.produtoDTO.ProdutoAtualizarDTO;
import com.example.api.wine.dtos.produtoDTO.ProdutoCadastroDTO;
import com.example.api.wine.dtos.produtoDTO.ProdutoListagemDTO;
import com.example.api.wine.entities.Produto;
import com.example.api.wine.repositories.ProdutoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto criarProduto(ProdutoCadastroDTO produtoCadastroDTO){
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
