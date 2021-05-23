package com.udemy.compras.graphql;

import com.udemy.compras.domain.Cliente;
import com.udemy.compras.domain.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraInput {

    private Long id;

    private Date data;

    private Integer quantidade;

    private String status;

    private Long clienteId;

    private Long produtoId;

}
