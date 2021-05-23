package com.udemy.compras.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente findById(Long id){
        return clienteRepository.findById(id).orElse(null);
    }

//    @Cacheable("clientes")
    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    @Transactional
    public Cliente save(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @Transactional
    public Boolean deleteById(Long id){
        if(clienteRepository.findById(id).isPresent()){
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
