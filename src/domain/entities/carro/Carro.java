package domain.entities.carro;

import domain.entities.Entidade;
import domain.enums.TipoCarroEnum;

import java.math.BigDecimal;

public class Carro implements Entidade {
    private String placa;
    private String modelo;
    private BigDecimal valorDiaria;
    private TipoCarroEnum tipoCarroEnum;

    public Carro() {
    }

    public Carro(String placa, String modelo, TipoCarroEnum tipoCarroEnum) {
        this.placa = placa;
        this.modelo = modelo;
        this.tipoCarroEnum = tipoCarroEnum;
        this.valorDiaria = this.getValorDiaria();
    }

    public Carro(String placa, String modelo, String tipoCarroEnumStr) {
        this.placa = placa;
        this.modelo = modelo;
        this.tipoCarroEnum = TipoCarroEnum.valueOf(tipoCarroEnumStr);
        this.valorDiaria = this.getValorDiaria();
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return this.getId();
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    @Override
    public String getId() {
        return this.placa;
    }


    public TipoCarroEnum getTipoCarroEnum() {
        return tipoCarroEnum;
    }

    public void setTipoCarroEnum(TipoCarroEnum tipoCarroEnum) {
        this.tipoCarroEnum = tipoCarroEnum;
    }

    public BigDecimal getValorDiaria() {
        switch (this.getTipoCarroEnum()) {
            case TipoCarroEnum.PEQUENO:
                return BigDecimal.valueOf(100.0);
            case TipoCarroEnum.MEDIO:
                return BigDecimal.valueOf(150.0);
            case TipoCarroEnum.SUV:
                return BigDecimal.valueOf(200.0);
            default:
                return BigDecimal.ZERO;
        }
    }

    @Override
    public String toCsvString() {
        return placa + "," + modelo + "," + tipoCarroEnum.name();
    }

    @Override
    public Carro fromCsvString(String csv) {
        String[] parts = csv.split(",");
        return new Carro(parts[0], parts[1], parts[2]);
    }


}
