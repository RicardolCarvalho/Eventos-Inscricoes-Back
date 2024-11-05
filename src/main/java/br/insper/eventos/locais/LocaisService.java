package br.insper.eventos.locais;

import br.insper.eventos.eventos.Eventos;
import br.insper.eventos.eventos.EventosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class LocaisService {

    @Autowired
    private LocaisRepository locaisRepository;

    @Autowired
    private EventosRepository eventosRepository;

    // Método para cadastrar um novo local
    public RetornarLocaisDTO cadastrarLocal(CadastraLocaisDTO dto) {
        Locais local = new Locais();
        local.setNome(dto.getNome());
        local.setEndereco(dto.getEndereco());
        local.setCapacidade(dto.getCapacidadde());

        local = locaisRepository.save(local);
        return new RetornarLocaisDTO(local.getNome(), local.getEndereco(), local.getCapacidade());
    }

    // Método para listar locais com filtro opcional de nome e paginação
    public Page<Locais> listarLocais(String nome, Pageable pageable) {
        if (nome != null) {
            return locaisRepository.findByNome(nome, pageable);
        }
        return locaisRepository.findAll(pageable);
    }

    // Método auxiliar para buscar um local pelo ID
    public Locais buscarLocal(String id) {
        return locaisRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Local não encontrado"));
    }

    // Método para excluir um local se não houver eventos associados
    public boolean excluirLocal(String id) {
        // Verifica se há eventos associados ao local
        if (eventosRepository.existsByLocalId(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O local não pode ser excluído, pois há eventos associados a ele.");
        }

        Locais local = locaisRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Local não encontrado"));

        locaisRepository.delete(local);
        return true;
    }

    // Método para gerar um relatório de eventos para um local específico
    public Optional<String> gerarRelatorioLocal(String id) {
        Locais local = buscarLocal(id);
        if (local.getEventos().isEmpty()) {
            return Optional.of("Nenhum evento foi realizado neste local.");
        }

        StringBuilder relatorio = new StringBuilder("Relatório do Local: " + local.getNome() + "\n");
        relatorio.append("Total de eventos: ").append(local.getEventos().size()).append("\n");

        for (Eventos evento : local.getEventos()) {
            relatorio.append(" - ").append(evento.getNome()).append("\n");
        }

        return Optional.of(relatorio.toString());
    }
}
