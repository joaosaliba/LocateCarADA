package view;

import domain.entities.carro.Carro;
import domain.enums.TipoCarroEnum;
import services.CarroService;
import utils.ScannerSingleton;

import java.util.Objects;
import java.util.Scanner;

public class CarroView {
    private CarroService carroService;

    public CarroView(CarroService carroService) {
        this.carroService = carroService;
    }

    public void cadastrarCarroView(){
        try{

        Scanner scanner = ScannerSingleton.instance().getScanner();
        System.out.println("Digite a placa do véículo");
        String placa = scanner.next().trim().toUpperCase();

        System.out.println("Digite o TIPO do veiculo ( PEQUENO, MEDIO, SUV)");
        String tipo = scanner.next().trim().toUpperCase();

        System.out.println("Digite o Modelo do veiculo ");
        String modelo = scanner.next();

        Carro carro = new Carro(placa,modelo,TipoCarroEnum.valueOf(tipo));

        this.carroService.insert(carro);

            System.out.println("Carro cadastrado com sucesso!");
        }catch (Exception e){
            System.out.println("Carro já cadastrado tente novamete com outra placa");
        }

    }

    public void alterarCarro() {
        Scanner scanner = ScannerSingleton.instance().getScanner();
        System.out.println("Digite a placa do carro para se alterar");
        String placa = scanner.next().trim().toUpperCase();
        try{

            System.out.println("Digite o TIPO do veiculo ( PEQUENO, MEDIO, SUV)");

            String tipo = scanner.next().trim().toUpperCase();


            System.out.println("Digite o Modelo do veiculo ");
            String modelo = scanner.next();

            Carro carro = new Carro(placa,modelo,TipoCarroEnum.valueOf(tipo));
            this.carroService.update(carro);
        }catch (Exception e){
            System.out.println("Ocorreu um erro, generico pois nao quis fazer classes para cada tipo de erro");
        }
    }

    public void findByPlaca() {
        Scanner scanner = ScannerSingleton.instance().getScanner();
        System.out.println("Digite a placa do carro a se procurar");
        String placa = scanner.next().trim().toUpperCase();
        try{
        Carro carro = this.carroService.findById(placa);
            if(Objects.isNull(carro)){
                System.out.println("Carro não encontrado ");
                return;
            }
            this.showCarroInformations(carro);
        }catch (Exception e) {
            System.out.println("Ocorreu um erro, generico pois nao quis fazer classes para cada tipo de erro");
        }

    }

    private void showCarroInformations(Carro carro) {
        System.out.println("| PLACA | MODELO | TIPO | VALOR DIARIA |");
        System.out.printf("| %s | %s | %s | R$%s |",carro.getPlaca(),carro.getModelo(),carro.getTipoCarroEnum().name(),carro.getValorDiaria());
    }
}
