package com.zupteste.zuptest.service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenericService<T,I> {//NOPMD

    List<T> getAll();//NOPMD

    Page<T> getAllPaginated(Pageable pageable);//NOPMD

    Page<T> getAllPaginated(Pageable pageable, String value);//NOPMD

    T get(I id);//NOPMD

    T addOrUpdate(T entity);//NOPMD

    void remove(T entity);//NOPMD

    void removeById(I id);//NOPMD

}
