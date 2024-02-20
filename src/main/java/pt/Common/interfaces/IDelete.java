package pt.Common.interfaces;

public interface IDelete<T, K> {
    T deleteById(K id);
    T delete(T body);
}
