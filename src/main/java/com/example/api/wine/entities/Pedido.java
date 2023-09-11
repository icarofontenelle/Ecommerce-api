package com.example.api.wine.entities;

import java.time.LocalDate;

import com.example.api.wine.dtos.PedidoCadastroDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "pedido")
@Entity(name = "pedido")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido {
    
    public Pedido(PedidoCadastroDTO dados_pedido, Usuario usuario) {
        this.usuario = usuario;
        this.dataPedido = dados_pedido.dataPedido();
        this.total = dados_pedido.total();
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario; 
    
    private LocalDate dataPedido;
    private Double total;
}
