package domain.factory;

import domain.entities.PessoaFisica;
import domain.entities.PessoaJuridica;
import domain.abstracts.Pessoa;
import domain.enums.TipoPessoaEnum;

public class PessoaFactory {

    public static Pessoa getInstance(TipoPessoaEnum tipoPessoaEnum) {
        return switch (tipoPessoaEnum) {
            case PESSOA_FISICA -> new PessoaFisica();
            case PESSOA_JURIDICA -> new PessoaJuridica();
            default -> throw new IllegalArgumentException("Tipo Pessoa não encontrada");
        };

    }
}
