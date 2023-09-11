package com.example.api.wine.entities;

import java.time.LocalDate;

import com.example.api.wine.dtos.NotaCadastroDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "nota")
@Entity(name = "nota")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Nota {
    
    public Nota(NotaCadastroDTO dados_nota, Pedido pedido) {
        this.pedido = pedido;
        this.dataEmissao = dados_nota.dataEmissao();
        this.valorTotal = dados_nota.valorTotal();
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_pedido")
    Pedido pedido;
    
    private String cliente;
    LocalDate dataEmissao;
    Double valorTotal;
}
