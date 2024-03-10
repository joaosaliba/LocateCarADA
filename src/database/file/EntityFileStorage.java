package database.file;
import database.exception.EntityFileStorageException;
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



     public void salvarEmArquivo(List<T> lista) throws EntityFileStorageException {
          try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
               for (T entidade : lista) {
                    writer.write(entidade.toCsvString());
                    writer.newLine();
               }
          } catch (IOException e) {
               throw new EntityFileStorageException("Erro ao escrever arquivos "+ this.nomeArquivo,e);

          }
     }

     public List<T> carregarDoArquivo() throws EntityFileStorageException {
          List<T> lista = new ArrayList<>();
          try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
               String linha;
               while ((linha = reader.readLine()) != null) {
                    lista.add((T) factory.criarEntidade().fromCsvString(linha));
               }
          } catch (IOException e) {
               throw new EntityFileStorageException("Erro ao ler aquivio, ou arquivo não encontrado "+ this.nomeArquivo,e);
          }
          return lista;
     }
}
