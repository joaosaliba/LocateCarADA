package domain.entities.pessoa;

import domain.enums.TipoPessoaEnum;

public class PessoaFisica extends Pessoa {
    public PessoaFisica() {
        this.setTipoPessoaEnum(TipoPessoaEnum.PESSOA_FISICA);
    }


    public PessoaFisica(String cpf, String nome) {
        super(cpf, nome, TipoPessoaEnum.PESSOA_FISICA);

    }


}
