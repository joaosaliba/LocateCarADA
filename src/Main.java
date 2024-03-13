import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        InitializerMyProject initializer = InitializerMyProject.getInitializer();
        initializer.menuPrincipalView().execute();


//        Pessoa p = new PessoaFisica("1","joao");
//        initializer.pessoaService().insert(p);

//        Carro c = new Carro("PBS", "ARGO", "SUV");
//        initializer.carroService().insert(c);

//        Aluguel a = new Aluguel(p,c, LocalDateTime.now());

        InitializerMyProject.close(initializer);

    }


}