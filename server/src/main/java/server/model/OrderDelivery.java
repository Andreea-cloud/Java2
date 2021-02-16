package server.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="OrderDelivery")
@NamedQuery(name = "OrderDelivery.findByAddress", query = "SELECT o FROM OrderDelivery o WHERE o.address = :address")
@NamedQuery(name = "OrderDelivery.findById", query = "SELECT o FROM OrderDelivery o WHERE o.id = :id")
@NamedQuery(name = "OrderDelivery.deleteById", query = "DELETE FROM OrderDelivery o WHERE o.id = :id")
public class OrderDelivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String typePackage;

    @Column(nullable = false)
    private String weight;

    private int costIndex;

    @ManyToOne
    private User user;

    public void setId(int id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setAddress(String address) { this.address = address; }

    public void setTypePackage(String typePackage) { this.typePackage = typePackage; }

    public void setWeight(String weight) { this.weight = weight; }

    public void setCostIndex(int costIndex) { this.costIndex = costIndex; }

    public int getId() { return id; }

    public String getName() { return name; }

    public String getAddress() { return address; }

    public String getTypePackage() { return typePackage; }

    public String getWeight() { return weight; }

    public int getCostIndex() { return costIndex; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDelivery order = (OrderDelivery) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
