package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.domain.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class CompraGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private CompraService compraService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProdutoService produtoService;

    public Compra compra(Long id){
        return compraService.findById(id);
    }

    public List<Compra> compras(){
        return compraService.findAll();
    }

    public Compra saveCompra(CompraInput input){
        ModelMapper m = new ModelMapper();
        Compra compra = m.map(input, Compra.class);

        compra.setData(new Date());

        compra.setCliente(clienteService.findById(input.getClienteId()));
        compra.setProduto(produtoService.findById(input.getProdutoId()));

        return compraService.save(compra);
    }

    public Boolean deleteCompra(Long id){
        return compraService.deleteById(id);
    }

}
