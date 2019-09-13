package com.zupteste.zupTest.service.impl;

import com.zupteste.zupTest.domain.Client;
import com.zupteste.zupTest.repository.ClientRepository;
import com.zupteste.zupTest.service.ClientService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientServiceImpl extends BaseException implements ClientService {

    @Autowired
    ClientRepository repository;

    @Override
    public Page<Client> getAllPaginated(Pageable pageable, String value) throws Exception {
        try {
            if (Objects.isNull(value)) {
                return repository.findAll(pageable);
            } else {
                return repository.findByNameContains(pageable, value);
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Client get(Long id) {

        Optional<Client> client = repository.findById(id);
        super.verityNotFoundException(client);
        return client.get();
    }

    @Override
    public Client addOrUpdate(Client entity)  {
        return this.repository.save(entity);
    }

    @Override
    public void remove(Client entity) throws Exception {
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
    public List<Client> getAll() {
        return null;
    }

    @Override
    public Page<Client> getAllPaginated(Pageable pageable) throws Exception {
        return null;
    }

    @Override
    public List<Client> findByName(String value) throws Exception {
        return null;
    }

}
