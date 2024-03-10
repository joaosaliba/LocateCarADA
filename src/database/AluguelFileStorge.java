package database;


import domain.entities.aluguel.Aluguel;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AluguelFileStorge implements EntityFileStorage<Aluguel> {
    private String nomeArquivo;

    public AluguelFileStorge(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public void salvarEmArquivo(List<Aluguel> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Aluguel entidade : lista) {
                writer.write(entidade.toCsvString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception according to your application's requirements
        }
    }

    @Override
    public List<Aluguel> carregarDoArquivo() {
        List<Aluguel> lista = new ArrayList<>();
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

    private String entidadeToCsv(Aluguel entidade) {
        return entidade.toCsvString();
    }

    private Aluguel csvToEntidade(String linha) {
        return new Aluguel().fromCsvString(linha);
    }
}

