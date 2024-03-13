import database.exception.EntityFileStorageException;
import database.file.EntityFileStorage;
import database.repository.Repository;
import database.repository.RepositoryImp;
import domain.entities.aluguel.Aluguel;
import domain.entities.carro.Carro;
import domain.entities.pessoa.Pessoa;
import domain.factory.AluguelFactory;
import domain.factory.CarroFactory;
import domain.factory.PessoaFactory;
import services.AluguelService;
import services.CarroService;
import services.PessoaService;
import view.AluguelView;
import view.CarroView;
import view.MenuPrincipalView;
import view.PessoaView;

import java.util.Set;

public record InitializerMyProject(EntityFileStorage<Carro> arquivoCarros, EntityFileStorage<Pessoa> arquivoClientes,
                                   EntityFileStorage<Aluguel> arquivoAlugueis,
                                   Set<Carro> carros, Set<Pessoa> pessoas, Set<Aluguel> alugueis,
                                   MenuPrincipalView menuPrincipalView,
                                   CarroView carroView, PessoaView pessoaView, AluguelView aluguelView) {
    public static InitializerMyProject getInitializer() throws EntityFileStorageException {
        EntityFileStorage<Carro> arquivoCarros = new EntityFileStorage<>("carro.csv", new CarroFactory());
        EntityFileStorage<Pessoa> arquivoClientes = new EntityFileStorage<>("pessoa.csv", new PessoaFactory());
        EntityFileStorage<Aluguel> arquivoAlugueis = new EntityFileStorage<>("alugueis.csv", new AluguelFactory());

        Set<Carro> carros = arquivoCarros.carregarDoArquivo();
        Set<Pessoa> pessoas = arquivoClientes.carregarDoArquivo();
        Set<Aluguel> alugueis = arquivoAlugueis.carregarDoArquivo();


        Repository<Carro, String> repositoryCarrosImp = new RepositoryImp<>(carros);
        Repository<Pessoa, String> repositoryPessoaImp = new RepositoryImp<>(pessoas);
        Repository<Aluguel, String> repositoryAlugueisImp = new RepositoryImp<>(alugueis);

        CarroService carroService = new CarroService(repositoryCarrosImp);
        PessoaService pessoaService = new PessoaService(repositoryPessoaImp);
        AluguelService aluguelService = new AluguelService(repositoryAlugueisImp);


        CarroView carroView = new CarroView(carroService);
        PessoaView pessoaView = new PessoaView(pessoaService);
        AluguelView aluguelView = new AluguelView(aluguelService);

        MenuPrincipalView menuPrincipalView = new MenuPrincipalView(carroView,
                pessoaView,
                aluguelView);

        return new InitializerMyProject(arquivoCarros, arquivoClientes, arquivoAlugueis,
                carros, pessoas, alugueis,
                menuPrincipalView,
                carroView, pessoaView, aluguelView
        );
    }

    public static void close(InitializerMyProject result) throws EntityFileStorageException {
        result.arquivoCarros().salvarEmArquivo(result.carros());
        result.arquivoClientes().salvarEmArquivo(result.pessoas());
        result.arquivoAlugueis().salvarEmArquivo(result.alugueis());
    }

}
