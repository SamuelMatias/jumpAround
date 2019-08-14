package org.academiadecodigo.codezillas.persistence.repository;

public interface RepositoryInterface<T> {

    T findById(Integer id);
    void add(T t);
    void remove(T t);
    void update(Integer id, T t);
}
