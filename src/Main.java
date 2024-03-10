import database.exception.EntityFileStorageException;
import database.file.EntityFileStorage;
import database.repository.Repository;
import database.repository.RepositoryImp;
import domain.entities.aluguel.Aluguel;
import domain.entities.carro.Carro;
import domain.entities.pessoa.Pessoa;
import domain.entities.pessoa.PessoaFisica;
import domain.factory.AluguelFactory;
import domain.factory.CarroFactory;
import domain.factory.PessoaFactory;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws EntityFileStorageException, SQLException {

            EntityFileStorage<Carro> arquivoCarros = new EntityFileStorage<>("carro.csv", new CarroFactory());
            EntityFileStorage<Pessoa> arquivoClientes = new EntityFileStorage<>("pessoa.csv", new PessoaFactory());
            EntityFileStorage<Aluguel> arquivoAlugueis = new EntityFileStorage<>("alugueis.csv", new AluguelFactory());

            List<Carro> carros = arquivoCarros.carregarDoArquivo();
            List<Pessoa> pessoas = arquivoClientes.carregarDoArquivo();
            List<Aluguel> alugueis = arquivoAlugueis.carregarDoArquivo();


            Repository<Carro, String> repositoryCarrosImp = new RepositoryImp<>(carros);
            Repository<Pessoa, String> repositoryPessoaImp = new RepositoryImp<>(pessoas);
            Repository<Aluguel, String> repositoryAlugueisImp = new RepositoryImp<>(alugueis);



        Pessoa p = new PessoaFisica("1","joao");
        repositoryPessoaImp.insert(p);
        Carro c= new Carro("PBS","ARGO","SUV");
        repositoryCarrosImp.insert(c);
        Aluguel a = new Aluguel(p,c, LocalDateTime.now());
        repositoryAlugueisImp.insert(a);

        arquivoCarros.salvarEmArquivo(carros);
        arquivoClientes.salvarEmArquivo(pessoas);
        arquivoAlugueis.salvarEmArquivo(alugueis);

    }
}