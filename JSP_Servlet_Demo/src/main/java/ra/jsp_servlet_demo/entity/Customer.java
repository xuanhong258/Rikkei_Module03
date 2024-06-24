package ra.jsp_servlet_demo.entity;

public class Customer {
    private String customerName;
    private String birthDate;
    private String address;
    private String imageUrl;

    public Customer() {
    }

    public Customer(String customerName, String birthDate, String address, String imageUrl) {
        this.customerName = customerName;
        this.birthDate = birthDate;
        this.address = address;
        this.imageUrl = imageUrl;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
