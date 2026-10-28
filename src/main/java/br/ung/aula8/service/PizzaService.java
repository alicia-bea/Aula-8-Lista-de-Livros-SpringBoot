package br.ung.aula8.service;

import br.ung.aula8.model.Pizza;
import br.ung.aula8.repository.PizzaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    private final PizzaRepository repository;

    public PizzaService(PizzaRepository repository) {
        this.repository = repository;
    }

    public Pizza cadastrar(Pizza pizza) {
        return repository.save(pizza);
    }

    public List<Pizza> listar() {
        return repository.findAll();
    }

    public Optional<Pizza> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public List<Pizza> buscarPorNome(String nome) {
        return repository.findByNomeContainingIgnoreCase(nome);
    }
}
