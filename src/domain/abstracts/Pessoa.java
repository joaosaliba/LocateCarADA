package domain.abstracts;


import domain.enums.TipoPessoaEnum;
import domain.factory.PessoaFactory;

public abstract class Pessoa {
    private Integer id;
    private String nome;

    private TipoPessoaEnum tipoPessoaEnum;

    public Pessoa() {
    }

    public Pessoa(Integer id, String nome, TipoPessoaEnum tipoPessoaEnum) {
        this.id = id;
        this.nome = nome;
        this.tipoPessoaEnum = tipoPessoaEnum;
    }

    public Integer getId() {
        return id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    protected TipoPessoaEnum getTipoPessoaEnum() {
        return tipoPessoaEnum;
    }

    protected void setTipoPessoaEnum(TipoPessoaEnum tipoPessoaEnum) {
        this.tipoPessoaEnum = tipoPessoaEnum;
    }


    public static class PessoaBuilder {
        private String nome;
        private TipoPessoaEnum tipoPessoaEnum;

        public Pessoa build() {
            Pessoa pessoa = PessoaFactory.getInstance(tipoPessoaEnum);

            pessoa.setNome(nome);

            return pessoa;
        }

        public PessoaBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }


        public PessoaBuilder tipoPessoa(TipoPessoaEnum tipoPessoaEnum) {
            this.tipoPessoaEnum = tipoPessoaEnum;
            return this;
        }


    }

}
