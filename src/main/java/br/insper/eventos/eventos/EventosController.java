package br.insper.eventos.eventos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventos")
public class EventosController {

    @Autowired
    private EventosService eventosService;

    // @PostMapping
    // @ResponseStatus(HttpStatus.CREATED)
    // public RetornarEventoDTO postEvento(@RequestBody CadastrarEventoDTO evento) {
    //     return eventosService.cadastrarEvento(evento);
    // }
}
