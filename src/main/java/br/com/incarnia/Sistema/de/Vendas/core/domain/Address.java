package br.com.incarnia.Sistema.de.Vendas.core.domain;

import br.com.incarnia.Sistema.de.Vendas.core.exceptions.AddressException;

import java.util.Objects;

public class Address {
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String CEP;
    private String complement;

    public Address() {}

    public Address(String street, String number, String neighborhood, String city, String state, String CEP, String complement) {
        setStreet(street);
        setNumber(number);
        setNeighborhood(neighborhood);
        setCity(city);
        setState(state);
        setCEP(CEP);
        setComplement(complement);
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {

        if(street == null || street.isBlank()) {
            throw new AddressException("Address street cannot be null or blank");
        }

        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {

        if(number == null || number.isBlank()) {
            throw new AddressException("Address number cannot be null or blank");
        }

        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {

        if(neighborhood == null || neighborhood.isBlank()) {
            throw new AddressException("Address neighborhood cannot be null or blank");
        }

        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {

        if(city == null || city.isBlank()) {
            throw new AddressException("Address city cannot be null or blank");
        }

        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {

        if(state == null || state.isBlank()) {
            throw new AddressException("Address state cannot be null or blank");
        }

        this.state = state;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {

        if(CEP == null || CEP.isBlank()) {
            throw new AddressException("Address CEP cannot be null or blank");
        }

        this.CEP = CEP;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(number, address.number) && Objects.equals(neighborhood, address.neighborhood) && Objects.equals(city, address.city) && Objects.equals(state, address.state) && Objects.equals(CEP, address.CEP) && Objects.equals(complement, address.complement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number, neighborhood, city, state, CEP, complement);
    }
}
