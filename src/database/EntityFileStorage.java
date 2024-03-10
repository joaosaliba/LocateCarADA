package database;
import domain.entities.Entidade;
import domain.factory.EntidadeFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class EntityFileStorage<T extends Entidade> {


     private String nomeArquivo;
     private EntidadeFactory<T> factory;

     public EntityFileStorage(String nomeArquivo,EntidadeFactory<T> factory) {
          this.nomeArquivo = nomeArquivo;
          this.factory=factory;
     }



     public void salvarEmArquivo(List<T> lista) {
          try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
               for (T entidade : lista) {
                    writer.write(entidade.toCsvString());
                    writer.newLine();
               }
          } catch (IOException e) {
               e.printStackTrace();
          }
     }

     public List<T> carregarDoArquivo() {
          List<T> lista = new ArrayList<>();
          try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
               String linha;
               while ((linha = reader.readLine()) != null) {
                    lista.add((T) factory.criarEntidade().fromCsvString(linha));
               }
          } catch (IOException e) {
               e.printStackTrace();
          }
          return lista;
     }
}
