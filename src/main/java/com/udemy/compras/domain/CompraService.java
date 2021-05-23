package com.udemy.compras.domain;

import com.udemy.compras.graphql.dto.CompraResumo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CompraService {

    @Autowired
    private CompraRepository rep;

    public Compra findById(Long id) {
        return rep.findById(id).orElse(null);
    }

    public List<Compra> findAll(Pageable pageable) {
        return rep.findAll(pageable).getContent();
    }

    @Transactional
    public Compra save(Compra c) {
        return rep.save(c);
    }

    @Transactional
    public Boolean deleteById(Long id) {
        if(rep.findById(id).isPresent()) {
            rep.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Compra> findAllByClienteAndQuantidade(Cliente c, int quantidade) {
        return rep.findAllByClienteAndQuantidade(c, quantidade);
    }

    public List<Compra> findAllByCliente(Cliente c) {
        return rep.findAllByCliente(c);
    }


    public List<CompraResumo> findAllComprasRelatorio() {
        return rep.findAllComprasRelatorio();
    }
}
