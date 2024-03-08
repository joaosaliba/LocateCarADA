package domain.entities;

import domain.abstracts.Pessoa;
import domain.enums.TipoPessoaEnum;

public class PessoaFisica extends Pessoa {
    public PessoaFisica() {
        this.setTipoPessoaEnum(TipoPessoaEnum.PESSOA_FISICA);
    }


    public PessoaFisica(Integer id, String nome, Long cpf) {
        super(id, nome, TipoPessoaEnum.PESSOA_FISICA);
        this.cpf = cpf;
    }
    private Long cpf;

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

}
