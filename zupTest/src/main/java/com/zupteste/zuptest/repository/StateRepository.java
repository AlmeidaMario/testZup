package com.zupteste.zuptest.repository;

import com.zupteste.zuptest.domain.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {//NOPMD

    Page<State> findByNameContains(Pageable pageable, String value);//NOPMD

    State findByName(String name);//NOPMD

}
