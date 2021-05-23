package com.udemy.compras.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findAllByClienteAndQuantidade(Cliente c, int quantidade);

    @Query("select c from Compra c where c.cliente = :cliente")
    List<Compra> findAllByCliente(@Param("cliente") Cliente c);



}