package server.repository;

import library.dto.ClientDTO;
import server.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class ClientRepository {

    private EntityManager em;

    public ClientRepository(){
        var emf = Persistence.createEntityManagerFactory("java2PU");
        this.em = emf.createEntityManager();
    }

    public Client create(ClientDTO clientDTO){
        Client c = new Client();

        c.setUsername(clientDTO.getUsername());
        c.setPassword(clientDTO.getPassword());

        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();

        return c;
    }

    public Optional<Client> findByUsername(String username){
        TypedQuery<Client> query = em.createNamedQuery("Client.findByUsername", Client.class);
        query.setParameter("username", username);
        return query.getResultStream().findFirst();
    }
}
