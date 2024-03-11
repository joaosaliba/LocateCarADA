import domain.entities.carro.Carro;

public class Main {
    public static void main(String[] args) throws Exception {

        Initializer initializer = Initializer.getInitializer();


//        Pessoa p = new PessoaFisica("1","joao");
//        initializer.pessoaService().insert(p);

        Carro c = new Carro("PBS", "ARGO", "SUV");
        initializer.carroService().insert(c);

//        Aluguel a = new Aluguel(p,c, LocalDateTime.now());

        Initializer.close(initializer);

    }


}