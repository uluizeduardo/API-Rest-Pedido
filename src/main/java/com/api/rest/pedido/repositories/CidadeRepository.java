package com.api.rest.pedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.rest.pedido.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
