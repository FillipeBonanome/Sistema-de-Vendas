package br.com.incarnia.Sistema.de.Vendas.infra.persistence.address;

import jakarta.persistence.Embeddable;

@Embeddable
public class AddressEntity {
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String CEP;
    private String complement;

    public AddressEntity() { }

    public AddressEntity(String street, String number, String neighborhood, String city, String state, String CEP, String complement) {
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.CEP = CEP;
        this.complement = complement;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }
}
