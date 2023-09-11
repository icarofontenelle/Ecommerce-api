package com.example.api.wine.entities;

import com.example.api.wine.dtos.EnderecoCadastroDTO;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    public Endereco(EnderecoCadastroDTO user_data) {
        this.rua = user_data.rua();
        this.bairro = user_data.bairro();
        this.cidade = user_data.cidade();
        this.uf = user_data.uf();
        this.cep = user_data.cep();
    }
    
    
    private String rua; 
    private String bairro; 
    private String cidade; 
    private String uf;
    private String cep;
    
    public void atualizarInformacoes(EnderecoCadastroDTO enderecoAtualizarDados) {
        if(enderecoAtualizarDados.rua() != null){
            this.rua = enderecoAtualizarDados.rua();
        }
        if(enderecoAtualizarDados.bairro() != null){
            this.bairro = enderecoAtualizarDados.bairro();
        }
        if(enderecoAtualizarDados.cidade() != null){
            this.cidade = enderecoAtualizarDados.cidade();
        }
        if(enderecoAtualizarDados.uf() != null){
            this.uf = enderecoAtualizarDados.uf();
        }
        if(enderecoAtualizarDados.cep() != null){
            this.cep = enderecoAtualizarDados.cep();
        }
    }
}
