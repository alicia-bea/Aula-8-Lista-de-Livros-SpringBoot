package br.ung.aula8.repository;

import br.ung.aula8.model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    List<Pizza> findByNomeContainingIgnoreCase(String nome);
}
