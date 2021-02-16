package client.controller;

import library.dto.OrderDTO;
import library.service.OrderService;
import library.service.UserService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class OrderController {

        private static final class SingletonHolder{
                public static final OrderController INSTANCE = new OrderController();
        }

        private OrderService orderService;

        private OrderController(){
                try{
                        Registry registry = LocateRegistry.getRegistry("localhost", 4545);
                        orderService = (OrderService)registry.lookup("orderService");
                }catch(RemoteException | NotBoundException e){
                        e.printStackTrace();
                        throw  new RuntimeException(e);
                }
        }

        public static OrderController getInstance(){
                return OrderController.SingletonHolder.INSTANCE;
        }

        public int placeOrder(OrderDTO orderDTO){
                try{
                        return orderService.placeOrder(orderDTO);
                }catch (RemoteException e){
                        throw new RuntimeException(e);
                }
        }
        public int deleteOrder(OrderDTO orderDTO){
                try{
                        return orderService.deliverOrder(orderDTO);
                }catch (RemoteException e){
                        return 0;
                }
        }

}


