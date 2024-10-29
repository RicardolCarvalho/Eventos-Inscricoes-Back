package br.insper.eventos.eventos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/eventos")
public class EventosController {

    @Autowired
    private EventosService eventosService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RetornarEventoDTO postEvento(@RequestBody CadastrarEventoDTO evento) {
        return eventosService.cadastrarEvento(evento);
    }

    @GetMapping
    public Page<Eventos> listarEventos(@RequestParam(required = false) String nome, Pageable pageable) {
        return eventosService.listarEventos(nome, pageable);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirEvento(@PathVariable String id) {
        eventosService.excluirEvento(id);
    }

    @GetMapping("/{id}/participantes")
    public ArrayList<String> listarParticipantes(@PathVariable String id) {
        return eventosService.listarParticipantes(id);
    }

    @PostMapping("/{id}/participantes")
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionarParticipante(@PathVariable String id, @RequestBody String participante) {
        eventosService.adicionarParticipante(id, participante);
    }
}
