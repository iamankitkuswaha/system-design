package entity;

public class Guest {
    private final String id;
    private String name;
    private String email;
    private String phoneNumber;

    public Guest(String id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = "9999999999";
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
