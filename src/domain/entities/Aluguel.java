package domain.entities;

import domain.abstracts.Pessoa;

import java.time.LocalDateTime;

public class Aluguel {
    private Pessoa pessoa;
    private LocalDateTime dthRetirada;
    private LocalDateTime dthDevolucao;
}
