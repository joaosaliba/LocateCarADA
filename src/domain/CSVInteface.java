package domain;

import domain.entities.Entidade;

public interface CSVInteface {
    String toCsvString();

    Entidade fromCsvString(String csv);
}
