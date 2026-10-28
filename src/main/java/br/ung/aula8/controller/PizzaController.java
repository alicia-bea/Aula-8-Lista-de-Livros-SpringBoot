package br.ung.aula8.controller;

import br.ung.aula8.model.Pizza;
import br.ung.aula8.service.PizzaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    private final PizzaService service;

    public PizzaController(PizzaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Pizza> cadastrar(@RequestBody Pizza pizza) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(pizza));
    }

    @GetMapping
    public List<Pizza> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pizza> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Nova funcionalidade: GET /pizzas/buscar?nome=calabresa
    @GetMapping("/buscar")
    public List<Pizza> buscarPorNome(@RequestParam String nome) {
        return service.buscarPorNome(nome);
    }
}
