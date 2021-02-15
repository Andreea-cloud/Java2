package server.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQuery(name = "Order.findByCostIndex", query = "SELECT o FROM Order o WHERE o.costIndex = :costIndex")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String address;

    private String typePackage;

    private String weight;

    private int costIndex;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
