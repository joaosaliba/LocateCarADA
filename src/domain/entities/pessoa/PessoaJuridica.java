package domain.entities.pessoa;

import domain.enums.TipoPessoaEnum;

public class PessoaJuridica extends Pessoa {
    public PessoaJuridica() {
        this.setTipoPessoaEnum(TipoPessoaEnum.PESSOA_JURIDICA);
    }

    public PessoaJuridica(String cnpj, String nome) {
        super(cnpj, nome, TipoPessoaEnum.PESSOA_JURIDICA);
    }

}
