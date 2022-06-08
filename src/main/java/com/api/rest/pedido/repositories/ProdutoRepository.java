package com.api.rest.pedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.pedido.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
