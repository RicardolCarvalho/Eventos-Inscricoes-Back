package br.insper.eventos.eventos;

import br.insper.eventos.locais.Locais;
import br.insper.eventos.locais.LocaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@Service
public class EventosService {

    @Autowired
    private EventosRepository eventosRepository;

    @Autowired
    private LocaisService locaisService;

    public RetornarEventoDTO cadastrarEvento(CadastrarEventoDTO dto) {
        if (dto.nome() == null || dto.nome().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O nome do evento é obrigatório.");
        }

        if (dto.capacidade() == null || dto.capacidade() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A capacidade deve ser maior que zero.");
        }

        if (dto.localId() == null || dto.localId().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O local do evento é obrigatório.");
        }

        // Obtém o local pelo localId para adicionar o nome do local
        Locais local = locaisService.buscarLocal(dto.localId());
        if (local == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Local não encontrado.");
        }

        Eventos evento = new Eventos();
        evento.setNome(dto.nome());
        evento.setLocalId(dto.localId());
        evento.setLocalNome(local.getNome()); // Define o nome do local
        evento.setDataHora(dto.dataHora());
        evento.setCapacidade(dto.capacidade());

        evento = eventosRepository.save(evento);
        return new RetornarEventoDTO(
                evento.getId(),
                evento.getNome(),
                evento.getLocalId(),
                evento.getLocalNome(),
                evento.getDataHora(),
                evento.getCapacidade(),
                evento.getParticipantes()
        );
    }



    public Page<Eventos> listarEventos(String nome, Pageable pageable) {
        if (nome != null) {
            return eventosRepository.findByNome(nome, pageable);
        }
        return eventosRepository.findAll(pageable);
    }

    public void excluirEvento(String id) {
        Eventos evento = eventosRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento não encontrado"));

        eventosRepository.delete(evento);
    }

    public ArrayList<String> listarParticipantes(String id) {
        Eventos evento = eventosRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento não encontrado"));
        return evento.getParticipantes();
    }

    public void adicionarParticipante(String id, String participante) {
        Eventos evento = eventosRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Evento não encontrado"));

        if (!evento.adicionarParticipante(participante)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Capacidade máxima atingida.");
        }

        eventosRepository.save(evento);
    }
}
