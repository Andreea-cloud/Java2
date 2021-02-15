package library.dto;

import java.io.Serializable;

public class OrderDTO implements Serializable {

    private int id;
    private String name;
    private String address;
    private String typePackage;
    private String weight;
    private int costIndex;

    public OrderDTO(int id, String name, String address, String typePackage, String weight, int costIndex) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.typePackage = typePackage;
        this.weight = weight;
        this.costIndex = costIndex;
    }

    OrderDTO(){
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }

    public void setAddress(String address) { this.address = address; }

    public String getTypePackage() { return typePackage; }

    public void setTypePackage(String typePackage) { this.typePackage = typePackage; }

    public String getWeight() { return weight; }

    public void setWeight(String weight) { this.weight = weight; }

    public int getCostIndex() { return costIndex; }

    public void setCostIndex(int costIndex) { this.costIndex = costIndex; }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", typePackage='" + typePackage + '\'' +
                ", weight='" + weight + '\'' +
                ", costIndex=" + costIndex +
                '}';
    }
}
