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
    public static void main(String[] args) throws Exception {

        Initializer initializer = Initializer.getInitializer();


//        Pessoa p = new PessoaFisica("1","joao");
//        initializer.pessoaService().insert(p);

        Carro c= new Carro("PBS","ARGO","SUV");
        initializer.carroService().insert(c);

//        Aluguel a = new Aluguel(p,c, LocalDateTime.now());

        Initializer.close(initializer);

    }




}