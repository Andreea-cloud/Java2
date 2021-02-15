package server.repository;

import library.dto.OrderDTO;
import server.model.Order;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class OrderRepository {

    private EntityManager em;

    public OrderRepository(){
        var emf = Persistence.createEntityManagerFactory("java2PU");
        this.em = emf.createEntityManager();
    }

    public Order create(OrderDTO orderDTO){
        Order o = new Order();

        o.setName(orderDTO.getName());
        o.setAddress(orderDTO.getAddress());
        o.setTypePackage(orderDTO.getTypePackage());
        o.setWeight(orderDTO.getWeight());
        o.setCostIndex(orderDTO.getCostIndex());

        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();

        return o;
    }

    public Order delivery(OrderDTO orderDTO){

        return null;
    }

    public Optional<Order> findByAddress(String address){
        TypedQuery<Order> query = em.createNamedQuery("Order.findByAddress", Order.class);
        query.setParameter("address", address);
        return query.getResultStream().findFirst();
    }
}
