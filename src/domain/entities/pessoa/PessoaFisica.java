package domain.entities.pessoa;

import domain.enums.TipoPessoaEnum;

public class PessoaFisica extends Pessoa {
    public PessoaFisica() {
        this.setTipoPessoaEnum(TipoPessoaEnum.FISICA);
    }


    public PessoaFisica(String cpf, String nome) {
        super(cpf, nome, TipoPessoaEnum.FISICA);

    }


}
