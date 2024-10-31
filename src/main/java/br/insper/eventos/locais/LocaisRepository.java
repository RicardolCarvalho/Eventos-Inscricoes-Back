package br.insper.eventos.locais;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocaisRepository extends MongoRepository<Locais, String> {
    Page<Locais> findByNome(String nome, Pageable pageable);
}