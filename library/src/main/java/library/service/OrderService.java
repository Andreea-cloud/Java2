package library.service;

import library.dto.OrderDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface OrderService extends Remote {
        int placeOrder(OrderDTO orderDTO) throws RemoteException;
        int deliverOrder(OrderDTO orderDTO) throws RemoteException;
}
