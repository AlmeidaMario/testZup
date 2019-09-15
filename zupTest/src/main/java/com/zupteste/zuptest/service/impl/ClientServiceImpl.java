package com.zupteste.zuptest.service.impl;

import com.zupteste.zuptest.domain.Client;
import com.zupteste.zuptest.repository.ClientRepository;
import com.zupteste.zuptest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientServiceImpl extends BaseException implements ClientService {//NOPMD

    @Autowired
    private ClientRepository repository;//NOPMD

    @Override
    public Page<Client> getAllPaginated(final Pageable pageable, final String value) {
        if (Objects.isNull(value)) {
            return repository.findAll(pageable);//NOPMD
        } else {
            return repository.findByNameContains(pageable, value);
        }
    }

    @Override
    public Client get(Long id) {//NOPMD

        final Optional<Client> client = repository.findById(id);
        super.verityNotFoundException(client);
        return client.get();//NOPMD
    }

    @Override
    public Client addOrUpdate(final Client entity)  {
        return this.repository.save(entity);
    }

    @Override
    public void remove(final Client entity) {
        repository.delete(entity);
    }

    @Override
    public void removeById(Long id) {//NOPMD
        repository.deleteById(id);
    }

    @Override
    public List<Client> getAll() {
        return null;
    }

    @Override
    public Page<Client> getAllPaginated(final Pageable pageable){
        return null;
    }

    @Override
    public List<Client> findByName(final String value){
        return null;
    }

    @Override
    public Client getByCPF(final String cpf) {
        return repository.findByCpf(cpf);
    }

}
