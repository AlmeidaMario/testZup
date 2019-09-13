package com.zupteste.zupTest.service;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenericService<T,I> {

    T saveOrUpdate(T entity) throws Exception;

    List<T> getAll();

    Page<T> getAllPaginated(Pageable pageable) throws Exception;

    Page<T> getAllPaginated(Pageable pageable, String value) throws Exception;

    T get(I id);

    T add(T entity) throws Exception;

    T update(T entity) throws Exception;

    void remove(T entity) throws Exception;

    void removeById(I id) throws Exception;

}
