package com.ufc.br.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufc.br.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
