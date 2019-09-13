package com.zupteste.zupTest.repository;

import com.zupteste.zupTest.domain.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    Page<State> findByName(Pageable pageable, String value);
}
