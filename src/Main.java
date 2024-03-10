import database.EntityFileStorage;
import domain.entities.pessoa.Pessoa;
import domain.entities.aluguel.Aluguel;
import domain.entities.carro.Carro;
import domain.entities.pessoa.PessoaFisica;
import domain.factory.AluguelFactory;
import domain.factory.CarroFactory;
import domain.factory.PessoaFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         List<Carro> veiculos = new ArrayList<>();
         List<Pessoa> clientes = new ArrayList<>();
         List<Aluguel> alugueis = new ArrayList<>();

         EntityFileStorage<Carro> arquivoCarros = new EntityFileStorage<>("carro.csv", new CarroFactory());
         EntityFileStorage<Pessoa> arquivoClientes = new EntityFileStorage<>("pessoa.csv",new PessoaFactory());
         EntityFileStorage<Aluguel> arquivoAlugueis = new EntityFileStorage<>("alugueis.csv",new AluguelFactory());

//         Pessoa pessa = new PessoaFisica("1","joao");
//        clientes.add(pessa);
//        arquivoClientes.salvarEmArquivo(clientes);
        clientes= arquivoClientes.carregarDoArquivo();
        System.out.println(clientes);

    }
}