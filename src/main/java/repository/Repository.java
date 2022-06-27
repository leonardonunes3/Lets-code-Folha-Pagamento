package repository;

import java.util.List;

public interface Repository<T> {

    void salvar(T entity);

    void atualizar(T entity);

    void excluir(T entity);

    List<T> recuperarTodos();
}
