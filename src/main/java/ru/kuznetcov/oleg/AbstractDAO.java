package ru.kuznetcov.oleg;

import java.util.List;

public interface AbstractDAO<K extends Number, T> {
	public List<T> findALL();

	public T findEntityById(K id);

	public boolean delete(K id);

	public boolean delete(T entity);

	public boolean create(T entity);

	public T update(T entity);
}