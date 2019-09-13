package com.zupteste.zupTest.service;

import com.zupteste.zupTest.domain.Client;
import java.util.List;


public interface  ClientService extends GenericService<Client, Long> {

     List<Client> findByName(String value) throws Exception;
}
