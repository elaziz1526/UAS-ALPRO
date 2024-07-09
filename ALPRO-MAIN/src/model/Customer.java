package model;

public class Customer extends Akun {
    private String idCustomer;

    public String getidCustomer() {
        return this.idCustomer;
    }

    public Customer setidCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
        return this;
    }

}
