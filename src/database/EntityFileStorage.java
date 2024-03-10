package database;
import domain.entities.Entidade;

import java.util.List;
public interface EntityFileStorage<T extends Entidade> {


     void salvarEmArquivo(List<T> lista) ;

     List<T> carregarDoArquivo() ;



}
