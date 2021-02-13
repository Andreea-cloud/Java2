package library.service;

import library.dto.ClientDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientService extends Remote {

    int login(ClientDTO clientDTO) throws RemoteException;
    int register(ClientDTO clientDTO) throws RemoteException;
}
