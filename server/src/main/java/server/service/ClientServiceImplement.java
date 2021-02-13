package server.service;

import library.dto.ClientDTO;
import library.service.ClientService;
import server.model.Client;
import server.repository.ClientRepository;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Optional;

public class ClientServiceImplement extends UnicastRemoteObject implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImplement() throws RemoteException{
        clientRepository = new ClientRepository();
    }

    @Override
    public int login(ClientDTO clientDTO) throws RemoteException {
        Optional<Client> clientOptional = clientRepository
                .findByUsername(clientDTO.getUsername());
        return clientOptional
                .filter(client -> client.getPassword().equals(clientDTO.getPassword()))
                .map(Client::getId)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public int register(ClientDTO clientDTO) throws RemoteException {
        Optional<Client> clientOptional = clientRepository
                .findByUsername(clientDTO.getUsername());
        if(clientOptional.isEmpty()){
            return clientRepository.create(clientDTO).getId();
        }else{
            throw  new IllegalArgumentException();
        }
    }
}
