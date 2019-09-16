package com.zupteste.zuptest.service;

import com.zupteste.zuptest.domain.Client;
import java.util.List;


public interface  ClientService extends GenericService<Client, Long> {//NOPMD

     List<Client> findByName(String value);//NOPMD

     Client getByCPF(String cpf);//NOPMD

     Client getByName(String name);//NOPMD

}
