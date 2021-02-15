package server.service;

import library.dto.OrderDTO;
import library.service.OrderService;
import server.model.Order;
import server.repository.OrderRepository;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Optional;

public class OrderServiceImplement extends UnicastRemoteObject implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImplement() throws RemoteException{
        orderRepository = new OrderRepository();
    }

    @Override
    public int placeOrder(OrderDTO orderDTO) throws RemoteException {
        Optional<Order> orderOptional = orderRepository.findByAddress(orderDTO.getAddress());
        return orderRepository.create(orderDTO).getId();
    }

    @Override
    public int deliverOrder(OrderDTO orderDTO) throws RemoteException {
        return 0;
    }
}
