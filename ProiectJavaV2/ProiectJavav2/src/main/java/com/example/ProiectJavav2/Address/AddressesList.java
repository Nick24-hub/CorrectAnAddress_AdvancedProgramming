package com.example.ProiectJavav2.Address;

import java.util.ArrayList;
import java.util.List;

public class AddressesList {
    private List<Addresses> addressesList;

    public AddressesList() {
        addressesList=new ArrayList<>();
    }

    public AddressesList(List<Addresses> addressesList) {
        this.addressesList = addressesList;
    }

    public List<Addresses> getAddressesList() {
        return addressesList;
    }

    public void setAddressesList(List<Addresses> addressesList) {
        this.addressesList = addressesList;
    }
    public void addAddressesList(Addresses address)
    {
        addressesList.add(address);
    }
}
