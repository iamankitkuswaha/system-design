package entity;

public class Customer {
    private final String id;
    private final String name;
    private final String dlId;
    private final String contactNumber;

    public Customer(String id, String name, String dlId, String contactNumber) {
        this.id = id;
        this.name = name;
        this.dlId = dlId;
        this.contactNumber = contactNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public String getDlId() {
        return dlId;
    }

    public String getContactNumber() {
        return contactNumber;
    }
}
