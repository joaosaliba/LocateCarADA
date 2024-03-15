package view;

import utils.ScannerSingleton;

import java.util.Scanner;

public class MenuPrincipalView {
    private CarroView carroView;
    private PessoaView pessoaView;
    private AluguelView aluguelView;

    public MenuPrincipalView(CarroView carroView, PessoaView pessoaView, AluguelView aluguelView) {
        this.carroView = carroView;
        this.pessoaView = pessoaView;
        this.aluguelView = aluguelView;
    }

    public void execute() {
        Scanner scanner = ScannerSingleton.instance().getScanner();
        int opcao = -1;

        do {
            this.showOptions();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    this.carroView.cadastrarCarroView();
                    break;
                case 2:
                    this.carroView.alterarCarro();
                    break;
                case 3:
                    this.carroView.findByPlaca();
                    break;
                case 4:
                    this.pessoaView.cadastrarPessoa();
                    break;
                case 5:
                    this.pessoaView.alterarPessoa();
                    break;
                case 6:
                    this.aluguelView.aluguarVeiculo();
                    break;
                case 7:
                    this.aluguelView.devolverVeiculo();
                    break;
                case 8:
                    this.carroView.listarCarros();
                    break;

                case 9:
                    this.pessoaView.listarPessoas();
                    break;
                case 0: {
                    System.out.println("Saindo...");
                    scanner.close();
                }
                break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);
    }

    private void showOptions() {
        System.out.println("\n===== ADA LocateCar - Locadora de Veículos =====");
        System.out.println("1. Cadastrar Veículo");
        System.out.println("2. Alterar Veículo");
        System.out.println("3. Buscar Veículo por Nome");
        System.out.println("4. Cadastrar Cliente");
        System.out.println("5. Alterar Cliente");
        System.out.println("6. Alugar Veículo");
        System.out.println("7. Devolver Veículo");
        System.out.println("8. Listar Veículos");
        System.out.println("9. Listar Pessoas");
        System.out.println("0. Sair");
        System.out.print("Escolha a opção desejada: ");
    }
}
