package br.insper.eventos.locais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/locais")
public class LocaisController {

    @Autowired
    private LocaisService locaisService;

    // POST: Cria um novo local
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RetornarLocaisDTO postLocal(@RequestBody CadastraLocaisDTO localDTO) {
        return locaisService.cadastrarLocal(localDTO);
    }

    // GET: Lista todos os locais com paginação e filtro opcional pelo nome
    @GetMapping
    public Page<Locais> listarLocais(@RequestParam(required = false) String nome, Pageable pageable) {
        return locaisService.listarLocais(nome, pageable);
    }

    // DELETE: Exclui um local pelo ID se não houver eventos associados
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> excluirLocal(@PathVariable String id) {
        if (locaisService.excluirLocal(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    // GET: Gera um relatório de eventos por local
    @GetMapping("/{id}/relatorio")
    public ResponseEntity<String> getLocalReport(@PathVariable String id) {
        return locaisService.gerarRelatorioLocal(id).map(relatorio ->
                        new ResponseEntity<>(relatorio, HttpStatus.OK))
                .orElse(ResponseEntity.notFound().build());
    }
}
