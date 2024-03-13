package domain.entities.pessoa;


import domain.entities.Entidade;
import domain.enums.TipoPessoaEnum;
import domain.factory.PessoaFactory;

public class Pessoa implements Entidade {
    private String cpfCnpj;

    private String nome;

    private TipoPessoaEnum tipoPessoaEnum;

    public Pessoa() {
    }

    public Pessoa(String cpfCnpj, String nome, TipoPessoaEnum tipoPessoaEnum) {
        this.cpfCnpj = cpfCnpj;
        this.nome = nome;
        this.tipoPessoaEnum = tipoPessoaEnum;
    }


    @Override
    public String getId() {
        return cpfCnpj;
    }

    public String getCpfCnpj() {
        return this.getId();
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public TipoPessoaEnum getTipoPessoaEnum() {
        return tipoPessoaEnum;
    }

    protected void setTipoPessoaEnum(TipoPessoaEnum tipoPessoaEnum) {
        this.tipoPessoaEnum = tipoPessoaEnum;
    }


    @Override
    public String toCsvString() {
        return cpfCnpj + "," + nome + "," + tipoPessoaEnum.name();
    }

    @Override
    public Pessoa fromCsvString(String csv) {
        String[] parts = csv.split(",");
        Pessoa pessoa = PessoaFactory.getInstance(TipoPessoaEnum.valueOf(parts[2]));
        pessoa.setCpfCnpj(parts[0]);
        pessoa.setNome(parts[1]);
        return pessoa;
    }


    public static class PessoaBuilder {
        private String cpfCnpj;
        private String nome;
        private TipoPessoaEnum tipoPessoaEnum;

        public Pessoa build() {
            Pessoa pessoa = PessoaFactory.getInstance(tipoPessoaEnum);

            pessoa.setCpfCnpj(cpfCnpj);
            pessoa.setNome(nome);

            return pessoa;
        }

        public PessoaBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public PessoaBuilder cpfCnpj(String cpfCnpj) {
            this.cpfCnpj = cpfCnpj;
            return this;
        }


        public PessoaBuilder tipoPessoa(TipoPessoaEnum tipoPessoaEnum) {
            this.tipoPessoaEnum = tipoPessoaEnum;
            return this;
        }


    }

}
