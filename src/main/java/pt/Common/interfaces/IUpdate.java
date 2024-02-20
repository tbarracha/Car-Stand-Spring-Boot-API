package pt.Common.interfaces;

public interface IUpdate<T, K> {
    T update(K id, T body);
}
