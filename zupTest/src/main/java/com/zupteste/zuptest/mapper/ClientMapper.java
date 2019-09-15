package com.zupteste.zuptest.mapper;

import com.zupteste.zuptest.domain.Client;
import com.zupteste.zuptest.dto.ClientDTO;
import java.util.ArrayList;
import java.util.List;

public class ClientMapper {//NOPMD

    public static List<ClientDTO> convertToListDTO(final List<Client> clients){//NOPMD

        final List<ClientDTO> clientDTOS = new ArrayList<>();

        clients.forEach(client -> {
            clientDTOS.add(convertToDTO(client));
        });

        return clientDTOS;
    }

    public static List<Client> convertToListEntity(final List<ClientDTO> clientDTOS){//NOPMD

        final List<Client> clients = new ArrayList<>();

        clientDTOS.forEach(clientDTO -> {
            clients.add(convertToEntity(clientDTO));
        });

        return clients;
    }

    public static ClientDTO convertToDTO(final Client client){//NOPMD

        final ClientDTO dto = new ClientDTO();

        dto.setId(client.getId());
        dto.setCpf(client.getCpf());
        dto.setDataNascimento(client.getDataNascimento());
        dto.setName(client.getName());

        return dto;
    }

    public static Client convertToEntity(final ClientDTO clientDTO){//NOPMD
        final Client client = new Client();

        client.setId(clientDTO.getId());
        client.setCpf(clientDTO.getCpf());
        client.setName(clientDTO.getName());
        client.setDataNascimento(clientDTO.getDataNascimento());

        return client;
    }
}