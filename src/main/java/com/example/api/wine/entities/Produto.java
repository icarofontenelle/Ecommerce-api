package com.example.api.wine.entities;

import com.example.api.wine.dtos.ProdutoCadastroDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "produto")
@Entity(name = "produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {
    
    public Produto(ProdutoCadastroDTO dados_produto) {
        this.nome = dados_produto.nome();
        this.preco = dados_produto.preco();
        this.descricao = dados_produto.descricao();
        this.imagem = dados_produto.imagem();
        this.qtd_estoque = dados_produto.qtd_estoque();
    }
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome; 
    private Double preco; 
    private String descricao; 
    private String imagem; 
    private Integer qtd_estoque;
    
    public void atualizarInformacoes(ProdutoCadastroDTO produtoAtualizarDTO) {
        if(produtoAtualizarDTO.nome() != null) {
            this.nome = produtoAtualizarDTO.nome();
        }
        if(produtoAtualizarDTO.preco() != null) {
            this.preco = produtoAtualizarDTO.preco();
        }
        if(produtoAtualizarDTO.descricao() != null) {
            this.descricao = produtoAtualizarDTO.descricao();
        }
        if(produtoAtualizarDTO.imagem() != null) {
            this.imagem = produtoAtualizarDTO.imagem();
        }
        if(produtoAtualizarDTO.qtd_estoque() != null) {
            this.qtd_estoque = produtoAtualizarDTO.qtd_estoque();
        }
    }
}
