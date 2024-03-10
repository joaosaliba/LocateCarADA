import database.file.EntityFileStorage;
import database.repository.Repository;
import database.repository.RepositoryImp;
import domain.entities.aluguel.Aluguel;
import domain.entities.carro.Carro;
import domain.entities.pessoa.Pessoa;
import domain.factory.AluguelFactory;
import domain.factory.CarroFactory;
import domain.factory.PessoaFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)  {
        try {
            List<Carro> carros = new ArrayList<>();
            List<Pessoa> pessoas = new ArrayList<>();
            List<Aluguel> alugueis = new ArrayList<>();

            EntityFileStorage<Carro> arquivoCarros = new EntityFileStorage<>("carro.csv", new CarroFactory());
            EntityFileStorage<Pessoa> arquivoClientes = new EntityFileStorage<>("pessoa.csv", new PessoaFactory());
            EntityFileStorage<Aluguel> arquivoAlugueis = new EntityFileStorage<>("alugueis.csv", new AluguelFactory());


            pessoas = arquivoClientes.carregarDoArquivo();
            alugueis = arquivoAlugueis.carregarDoArquivo();
            carros = arquivoCarros.carregarDoArquivo();


            Repository<Carro, String> repositoryCarrosImp = new RepositoryImp<>(carros);
            Repository<Pessoa, String> repositoryPessoaImp = new RepositoryImp<>(pessoas);
            Repository<Aluguel, String> repositoryAlugueisImp = new RepositoryImp<>(alugueis);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}