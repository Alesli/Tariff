package entity;

public class User {

    public User() {
    }

    private long id;
    private String name;
    private String lastName;
    private String tariff;

    private Double balance;

    public User(long id, String name, String lastName, String tariff, Double balance) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.tariff = tariff;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTariff() {
        return tariff;
    }

    public void setTariff(String tariff) {
        this.tariff = tariff;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User " + id +
                "\n" + name + " " + lastName + "\n" +
                "tariff = " + tariff + "\n" +
                "balance = " + balance + "\n";
    }

}
