package com.zupteste.zuptest.service;

import com.zupteste.zuptest.domain.Client;
import java.util.List;


public interface  ClientService extends GenericService<Client, Long> {

     List<Client> findByName(String value);

     Client getByCPF(String cpf);
}
