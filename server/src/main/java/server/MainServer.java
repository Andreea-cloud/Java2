package server;

import server.service.ClientServiceImplement;
import server.service.OrderServiceImplement;
import server.service.UserServiceImplement;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MainServer {

    public static void main(String[] args) throws RemoteException {
        Registry registry = LocateRegistry.createRegistry(4545);
        registry.rebind("userService", new UserServiceImplement());
        registry.rebind("clientService", new ClientServiceImplement());
        registry.rebind("orderService", new OrderServiceImplement());
    }
}
