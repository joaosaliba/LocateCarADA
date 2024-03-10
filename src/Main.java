import database.AluguelFileStorge;
import database.CarroFileStorge;
import database.EntityFileStorage;
import database.PessoaFileStorge;
import domain.entities.pessoa.Pessoa;
import domain.entities.aluguel.Aluguel;
import domain.entities.carro.Carro;
import domain.entities.pessoa.PessoaFisica;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
         List<Carro> veiculos = new ArrayList<>();
         List<Pessoa> clientes = new ArrayList<>();
         List<Aluguel> alugueis = new ArrayList<>();

         EntityFileStorage<Carro> arquivoCarros = new CarroFileStorge("carro.csv");
         EntityFileStorage<Pessoa> arquivoClientes = new PessoaFileStorge("pessoa.csv");
         EntityFileStorage<Aluguel> arquivoAlugueis = new AluguelFileStorge("alugueis.csv");
        clientes= arquivoClientes.carregarDoArquivo();

//         Pessoa pessa = new PessoaFisica("1","joao");
//        clientes.add(pessa);
//        arquivoClientes.salvarEmArquivo(clientes);
        System.out.println(clientes);

    }
}