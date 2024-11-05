package br.insper.eventos.eventos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventosRepository extends MongoRepository<Eventos, String> {
    Page<Eventos> findByNome(String nome, Pageable pageable);
    boolean existsByLocalId(String localId);
}
