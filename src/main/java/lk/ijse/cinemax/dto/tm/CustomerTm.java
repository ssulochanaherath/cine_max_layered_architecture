package lk.ijse.cinemax.dto.tm;

public class CustomerTm {
    private String userId;
    private String customerId;
    private String customerName;
    private String customerAddress;
    private String customerTelephone;

    public CustomerTm() {
    }

    public CustomerTm(String userId, String customerId, String customerName, String customerAddress, String customerTelephone) {
        this.userId = userId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerTelephone = customerTelephone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerTelephone() {
        return customerTelephone;
    }

    public void setCustomerTelephone(String customerTelephone) {
        this.customerTelephone = customerTelephone;
    }

    @Override
    public String toString() {
        return "CustomerTm{" +
                "userId='" + userId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerTelephone='" + customerTelephone + '\'' +
                '}';
    }
}
