package domain.factory;

import domain.entities.pessoa.Pessoa;
import domain.entities.pessoa.PessoaFisica;
import domain.entities.pessoa.PessoaJuridica;
import domain.enums.TipoPessoaEnum;

public class PessoaFactory implements EntidadeFactory<Pessoa> {

    public static Pessoa getInstance(TipoPessoaEnum tipoPessoaEnum) {
        return switch (tipoPessoaEnum) {
            case PESSOA_FISICA -> new PessoaFisica();
            case PESSOA_JURIDICA -> new PessoaJuridica();
            default -> throw new IllegalArgumentException("Tipo Pessoa não encontrada");
        };

    }

    @Override
    public Pessoa criarEntidade() {
        return new Pessoa();
    }
}
