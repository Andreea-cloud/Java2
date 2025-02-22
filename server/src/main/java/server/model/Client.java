package server.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQuery(name = "Client.findByUsername", query = "SELECT c FROM Client c WHERE c.username = :username")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @ElementCollection
    private List<String> address;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public List<String> getAddress() { return address; }

    public void setAddress(List<String> address) { this.address = address; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
