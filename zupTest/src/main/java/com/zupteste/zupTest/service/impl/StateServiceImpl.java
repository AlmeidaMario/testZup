package com.zupteste.zupTest.service.impl;

import com.zupteste.zupTest.domain.State;
import com.zupteste.zupTest.repository.StateRepository;
import com.zupteste.zupTest.service.StateService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StateServiceImpl extends BaseException implements StateService {

    @Autowired
    StateRepository repository;

    @Override
    public Page<State> getAllPaginated(Pageable pageable, String value) throws Exception {
        try {
            if (Objects.isNull(value)) {
                return repository.findAll(pageable);
            } else {
                return repository.findByName(pageable, value);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public State get(Long id) {
        Optional<State> state = repository.findById(id);
        super.verityNotFoundException(state);
        return state.get();
    }

    @Override
    public State addOrUpdate(State entity) {
        return this.repository.save(entity);
    }

    @Override
    public void remove(State entity) throws Exception {
        try {
            repository.delete(entity);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void removeById(Long id) throws Exception {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<State> getAll() {
        return null;
    }

    @Override
    public Page<State> getAllPaginated(Pageable pageable) throws Exception {
        return null;
    }

}
