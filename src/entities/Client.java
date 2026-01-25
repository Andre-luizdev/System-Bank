package entities;

public class Client {

    private String name;
    private int taxId;
    private String email;

    public Client(String name, int taxId, String email) {
        this.name = name;
        this.taxId = taxId;
        this.email = email;
    }

    public Client() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTaxId() {
        return taxId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString(){
       return  "TaxId: " + getTaxId() +", Name: " + getName() + ", Email: " + getEmail();
    }
}
