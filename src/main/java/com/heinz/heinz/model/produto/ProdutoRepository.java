package com.heinz.heinz.model.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("""
            select p from Produto p where p.nomeProduto = :nome
            """)
    Produto getReferenceNome(String nome);


}
