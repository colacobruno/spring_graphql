package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.domain.*;
import com.udemy.compras.graphql.dto.CompraResumo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public List<Compra> compras(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return compraService.findAll(pageable);
    }

    public List<CompraResumo> comprasRelatorio() { return compraService.findAllComprasRelatorio(); }

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
