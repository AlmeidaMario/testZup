package com.zupteste.zupTest.mapper;

import com.zupteste.zupTest.domain.Client;
import com.zupteste.zupTest.dto.ClientDTO;
import java.util.ArrayList;
import java.util.List;

public class ClientMapper {

    public static List<ClientDTO> convertToListDTO(List<Client> clients){

        List<ClientDTO> clientDTOS = new ArrayList<>();

        clients.forEach(client -> {
            clientDTOS.add(convertToDTO(client));
        });

        return clientDTOS;
    }

    public static List<Client> convertToListEntity(List<ClientDTO> clientDTOS){

        List<Client> clients = new ArrayList<>();

        clientDTOS.forEach(clientDTO -> {
            clients.add(convertToEntity(clientDTO));
        });

        return clients;
    }

    public static ClientDTO convertToDTO(Client client){

        ClientDTO dto = new ClientDTO();

        dto.setId(client.getId());
        dto.setCpf(client.getCpf());
        dto.setDataNascimento(client.getDataNascimento());
        dto.setName(client.getName());

        return dto;
    }

    public static Client convertToEntity(ClientDTO clientDTO){
        Client client = new Client();

        client.setId(clientDTO.getId());
        client.setCpf(clientDTO.getCpf());
        client.setName(clientDTO.getName());
        client.setDataNascimento(clientDTO.getDataNascimento());

        return client;
    }
}