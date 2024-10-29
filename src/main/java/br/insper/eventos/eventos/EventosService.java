package br.insper.eventos.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventosService {

    @Autowired
    private EventosRepository eventosRepository;

    // public RetornarEventoDTO cadastrarEvento(CadastrarEventoDTO evento) {
}
