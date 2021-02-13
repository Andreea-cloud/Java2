package client.controller;

import library.dto.ClientDTO;
import library.service.ClientService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientController {

    private static final class SingletonHolder{
        public static final ClientController INSTANCE = new ClientController();
    }

    private ClientService clientService;

    private ClientController(){
        try{
            Registry registry = LocateRegistry.getRegistry("localhost", 4545);
            clientService = (ClientService)registry.lookup("clientService");
        }catch(RemoteException | NotBoundException e){
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    public static ClientController getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public int login(ClientDTO clientDTO){
        try{
            return clientService.login(clientDTO);
        }catch (RemoteException e){
            throw  new RuntimeException(e);
        }
    }

    public int register(ClientDTO clientDTO){
        try{
            return clientService.register(clientDTO);
        }catch (RemoteException e){
            throw new RuntimeException(e);
        }
    }
}
