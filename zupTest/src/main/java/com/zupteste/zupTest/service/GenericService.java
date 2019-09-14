package com.zupteste.zupTest.service;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenericService<T,I> {

    List<T> getAll();

    Page<T> getAllPaginated(Pageable pageable);

    Page<T> getAllPaginated(Pageable pageable, String value);

    T get(I id);

    T addOrUpdate(T entity);

    void remove(T entity);

    void removeById(I id);

}
