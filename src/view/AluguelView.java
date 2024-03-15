package view;

import services.AluguelService;
import utils.ScannerSingleton;

import java.math.BigDecimal;
import java.util.Scanner;

public class AluguelView {
    private AluguelService aluguelService;

    public AluguelView(AluguelService aluguelService) {
        this.aluguelService = aluguelService;
    }

    public void aluguarVeiculo() {
        Scanner scanner = ScannerSingleton.instance().getScanner();
        try {

            System.out.println("Digite o cpf/cnpj para quem for alugar");
            String documento = scanner.next();
            System.out.println("Digite a placa do veículo alugado");
            String placa = scanner.next();
            this.aluguelService.aluguarVeiculo(documento, placa);
            System.out.println("Carro alugado");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro tente novamente" + e.getMessage());
        }
    }

    public void devolverVeiculo() {
        Scanner scanner = ScannerSingleton.instance().getScanner();
        try {

            System.out.println("Digite a placa do veículo a ser devolvido");
            String placa = scanner.next();
            BigDecimal valor = this.aluguelService.devolverVeiculo(placa);
            System.out.printf("Total a se pagar : R$%s", valor.toString());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro tente novamente " + e.getMessage());

        }
    }
}
