package view;

import domain.entities.pessoa.Pessoa;
import services.PessoaService;
import utils.ScannerSingleton;

import java.util.Objects;
import java.util.Scanner;

public class PessoaView {
    private PessoaService pessoaService;

    public PessoaView(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    public void cadastrarPessoa() {
        Scanner scanner = ScannerSingleton.instance().getScanner();
        System.out.println("Digite a CPF/CNPJ da pessoa");
        String documento = scanner.next().trim().toUpperCase();

        System.out.println("Digite o TIPO pessoa ( JURIDICA ,FISICA)");
        String tipo = scanner.next().trim().toUpperCase();

        System.out.println("Digite o Nome da pessoa ");
        String nome = scanner.next();


        try {

            this.pessoaService.insert(documento, nome, tipo);
        } catch (Exception e) {
            System.out.println("Ocorreu algum erro");
        }
    }

    public void alterarPessoa() {
        Scanner scanner = ScannerSingleton.instance().getScanner();
        try {
            System.out.println("Digite a CPF/CNPJ da pessoa");
            String documento = scanner.next().trim().toUpperCase();
            Pessoa pessoa = this.pessoaService.findById(documento);
            if (Objects.isNull(pessoa)) {
                System.out.println("Pessoa não encontrado ");
                return;
            }
            this.showInformations(pessoa);
            System.out.println();

            System.out.println("Digite o TIPO pessoa ( JURIDICA ,FISICA)");
            String tipo = scanner.next().trim().toUpperCase();

            System.out.println("Digite o Nome da pessoa ");
            String nome = scanner.next();


            this.pessoaService.alterarPessoa(documento, nome, tipo);
        } catch (Exception e) {
            System.out.println("Ocorreu algum erro");
        }
    }


    private void showInformations(Pessoa pessoa) {
        System.out.println("| CPF/CNPJ | NOME | TIPO |");
        System.out.printf("| %s | %s | %s |", pessoa.getId(), pessoa.getNome(), pessoa.getTipoPessoaEnum().name());
    }
}
