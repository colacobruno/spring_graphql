package com.udemy.compras.graphql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
public class ProdutoInput {

    private Long id;

    private String nome;

    private double valor;

}
