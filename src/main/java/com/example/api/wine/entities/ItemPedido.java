package com.example.api.wine.entities;


import com.example.api.wine.dtos.ItemPedidoCadastroDTO;

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

@Table(name = "itemPedido")
@Entity(name = "itemPedido")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ItemPedido {
    
    public ItemPedido(ItemPedidoCadastroDTO dados_ItemPedidoDTO, Pedido pedido, Produto produto) {
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = dados_ItemPedidoDTO.quantidade();
        this.precoUnitario = dados_ItemPedidoDTO.precoUnitario();
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
    
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    
    private int quantidade;
    private Double precoUnitario;
}
