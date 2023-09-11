package com.example.api.wine.entities;

import java.time.LocalDate;

import com.example.api.wine.dtos.UsuarioAtualizarDTO;
import com.example.api.wine.dtos.UsuarioCadastroDTO;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuario")
@Entity(name = "usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {
    
    public Usuario(UsuarioCadastroDTO dados_usuario) {
          this.ativo = true;
          this.nome = dados_usuario.nome();
          this.sobrenome = dados_usuario.sobrenome();
          this.nascimento = dados_usuario.nascimento();
          this.role = dados_usuario.role();
          this.email = dados_usuario.email();
          this.senha = dados_usuario.senha();
          this.cpf = dados_usuario.cpf();
          this.endereco = new Endereco(dados_usuario.endereco());
    }
   
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String sobrenome;
    private LocalDate nascimento;
    private String role;
    private String email;
    private String senha;
    private String cpf;

    private Boolean ativo;

    @Embedded
    Endereco endereco;

    public void atualizarInformacoes(UsuarioAtualizarDTO usuarioAtualizarDTO) {
       if(usuarioAtualizarDTO.nome() != null ){
            this.nome = usuarioAtualizarDTO.nome();
       }
       if(usuarioAtualizarDTO.sobrenome() != null){
            this.sobrenome = usuarioAtualizarDTO.sobrenome();
       }
       if(usuarioAtualizarDTO.endereco() != null){
            this.endereco.atualizarInformacoes(usuarioAtualizarDTO.endereco());
       }
    }

    public void excluirInformacoes() {
     this.ativo = false;
    }


}
