package server.repository;

import library.dto.OrderDTO;
import org.hibernate.hql.internal.ast.QuerySyntaxException;
import server.model.OrderDelivery;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.rmi.RemoteException;
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
        em.getTransaction().begin();
        TypedQuery<OrderDelivery> query = em.createNamedQuery("OrderDelivery.findById", OrderDelivery.class);
        query.setParameter("id", id);
        Optional<OrderDelivery> od = query.getResultStream().findFirst();
        em.getTransaction().commit();
        return od;
    }

    public int deleteById(int id){
        Query query;
        int res;
        em.getTransaction().begin();
        try{
            res = em.createQuery("DELETE OrderDelivery WHERE id = :id").setParameter("id", id)
                    .executeUpdate();

        }catch (Exception e){
            throw new RuntimeException(e);
        }
        em.getTransaction().commit();
        return res;
    }
}
