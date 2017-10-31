package model;

public class Publisher {
    private String publisher_name;
    private String address;
    private String phone;


    public Publisher(String publisher_name, String address, String phone) {
        this.publisher_name = publisher_name;
        this.address = address;
        this.phone = phone;
    }


    public String getPublisher_name() {
        return publisher_name;
    }

    public void setPublisher_name(String publisher_name) {
        this.publisher_name = publisher_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
