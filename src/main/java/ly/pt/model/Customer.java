package ly.pt.model;

public class Customer {
    private String CustomerID;
    private String Name;
    private String Address;
    private String Contact;

    public Customer() {
    }

    public Customer(String customerID, String name, String address, String contact) {
        CustomerID = customerID;
        Name = name;
        Address = address;
        Contact = contact;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getContact() {
        return Contact;
    }

    public void setContact(String contact) {
        Contact = contact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerID='" + CustomerID + '\'' +
                ", Name='" + Name + '\'' +
                ", Address='" + Address + '\'' +
                ", Contact='" + Contact + '\'' +
                '}';
    }
}
