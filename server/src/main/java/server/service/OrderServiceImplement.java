package server.service;

import library.dto.OrderDTO;
import library.service.OrderService;
import server.model.OrderDelivery;
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
        Optional<OrderDelivery> orderOptional = orderRepository.findByAddress(orderDTO.getAddress());
        return orderRepository.create(orderDTO).getId();
    }

    @Override
    public int deliverOrder(OrderDTO orderDTO) throws RemoteException {
        System.out.println(orderDTO.getId());

        Optional<OrderDelivery> orderOptional = orderRepository
                .findById(orderDTO.getId());

        if(!orderOptional.isEmpty()){
            orderRepository.deleteById(orderDTO.getId());
        }
        else {
            throw new IllegalArgumentException();
        }
        return orderDTO.getId();
    }
}
