package library.dto;

import java.io.Serializable;
import java.util.Objects;

public class ClientDTO implements Serializable {

    private int id;
    private String username;
    private String password;

    public ClientDTO(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    ClientDTO(){
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO clientDTO = (ClientDTO) o;
        return id == clientDTO.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
