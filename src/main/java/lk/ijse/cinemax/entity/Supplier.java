package lk.ijse.cinemax.entity;

public class Supplier {
    private String supplierId;
    private String name;
    private String address;
    private String tele;

    public Supplier() {
    }

    public Supplier(String supplierId, String name, String address, String tele) {
        this.supplierId = supplierId;
        this.name = name;
        this.address = address;
        this.tele = tele;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTele() {
        return tele;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    @Override
    public String toString() {
        return "SupplierDto{" +
                "supplierId='" + supplierId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tele='" + tele + '\'' +
                '}';
    }
}
