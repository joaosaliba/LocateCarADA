package domain.entities;

public interface Entidade<T>  {
    String getId();
    String toCsvString();
    T fromCsvString(String csv);
}
