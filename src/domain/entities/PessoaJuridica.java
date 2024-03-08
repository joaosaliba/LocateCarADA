package domain.entities;

import domain.abstracts.Pessoa;
import domain.enums.TipoPessoaEnum;

public class PessoaJuridica extends Pessoa {
    public PessoaJuridica() {
        this.setTipoPessoaEnum(TipoPessoaEnum.PESSOA_JURIDICA);
    }

    public PessoaJuridica(Integer id, String nome, Long cnpj) {
        super(id, nome, TipoPessoaEnum.PESSOA_JURIDICA);
        this.cnpj = cnpj;
    }

    private Long cnpj  ;

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }
}
