package server.repository;

import library.dto.OrderDTO;
import server.model.OrderDelivery;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class OrderRepository {

    private EntityManager em;

    public OrderRepository(){
        var emf = Persistence.createEntityManagerFactory("java2PU");
        this.em = emf.createEntityManager();
    }

    public OrderDelivery create(OrderDTO orderDTO){
        OrderDelivery o = new OrderDelivery();

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

    public Optional<OrderDelivery> findByAddress(String address){
        TypedQuery<OrderDelivery> query = em.createNamedQuery("OrderDelivery.findByAddress", OrderDelivery.class);
        query.setParameter("address", address);
        return query.getResultStream().findFirst();
    }

    public Optional<OrderDelivery> findById(int id){
        TypedQuery<OrderDelivery> query = em.createNamedQuery("OrderDelivery.findById", OrderDelivery.class);
        System.out.println("5");
        query.setParameter("id", id);
        System.out.println("6");
        return query.getResultStream().findFirst();
    }

    public int deleteById(int id){
        System.out.println("1");
        Query query = em.createQuery("OrderDelivery.deleteById",OrderDelivery.class);
//        Query query = em.createQuery("DELETE FROM Orders o WHERE o.id = :id");
        System.out.println("2");
        query.setParameter("id", id);
        System.out.println("3");
        query.executeUpdate();
        return 0;
//        System.out.println("4");
    }


}
