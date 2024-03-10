package database;

import domain.entities.pessoa.Pessoa;
import domain.entities.pessoa.PessoaFisica;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaFileStorge implements EntityFileStorage<Pessoa> {
    private String nomeArquivo;

    public PessoaFileStorge(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public void salvarEmArquivo(List<Pessoa> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Pessoa entidade : lista) {
                writer.write(entidade.toCsvString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception according to your application's requirements
        }
    }

    @Override
    public List<Pessoa> carregarDoArquivo() {
        List<Pessoa> lista = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                lista.add(csvToEntidade(linha));
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception according to your application's requirements
        }
        return lista;
    }

    private String entidadeToCsv(Pessoa entidade) {
        return entidade.toCsvString();
    }

    private Pessoa csvToEntidade(String linha) {
        return new Pessoa().fromCsvString(linha);
    }
}
