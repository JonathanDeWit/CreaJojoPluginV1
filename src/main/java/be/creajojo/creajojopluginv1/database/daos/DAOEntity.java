package be.creajojo.creajojopluginv1.database.daos;

public interface DAOEntity<T> {

    public int save(T t);

    public int count();

}
