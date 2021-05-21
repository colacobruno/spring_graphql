package com.udemy.compras.graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.udemy.compras.Cliente;
import com.udemy.compras.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
public class ClienteGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente cliente(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> clientes(){
        return clienteRepository.findAll();
    }

    @Transactional
    public Cliente saveCliente(Long id, String nome, String email){
        Cliente cliente = new Cliente(id, nome, email);
        cliente.setId(id);
        cliente.setNome(nome);
        cliente.setEmail(email);
        return clienteRepository.save(cliente);
    }


}
