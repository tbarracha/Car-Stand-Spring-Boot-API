package pt.Common.interfaces;

public interface IGet<T, K> {
    T getById(K id);

    <TCollection> TCollection getAll();
}
