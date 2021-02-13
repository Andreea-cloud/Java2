package server.repository;

import library.dto.UserDTO;
import server.model.User;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class UserRepository {

    private EntityManager em;

    public UserRepository(){
        var emf = Persistence
                .createEntityManagerFactory("java2PU");
        this.em = emf.createEntityManager();
    }

    public User create(UserDTO userDTO){
        User u = new User();

        u.setUsername(userDTO.getUsername());
        u.setPassword(userDTO.getPassword());

        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();

        return u;
    }


}
