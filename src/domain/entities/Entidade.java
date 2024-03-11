package domain.entities;

public interface Entidade {
    String getId();

    String toCsvString();

    Entidade fromCsvString(String csv);
}
