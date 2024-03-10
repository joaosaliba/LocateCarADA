package database;


import domain.entities.carro.Carro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CarroFileStorge  implements EntityFileStorage<Carro> {
    private String nomeArquivo;

    public CarroFileStorge(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public void salvarEmArquivo(List<Carro> lista) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (Carro entidade : lista) {
                writer.write(entidade.toCsvString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception according to your application's requirements
        }
    }

    @Override
    public List<Carro> carregarDoArquivo() {
        List<Carro> lista = new ArrayList<>();
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

    private String entidadeToCsv(Carro entidade) {
        return entidade.toCsvString();
    }

    private Carro csvToEntidade(String linha) {
        return new Carro().fromCsvString(linha);
    }
}
