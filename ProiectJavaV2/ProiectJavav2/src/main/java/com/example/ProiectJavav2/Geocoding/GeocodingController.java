package com.example.ProiectJavav2.Geocoding;

import com.example.ProiectJavav2.Address.Addresses;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeocodingController {

    public List<Addresses> GeocodingControllerAny(String query) throws IOException, InterruptedException {

        Geocoder geocoder = new Geocoder();
        String response = geocoder.GeocodeAny(query);
        return returnAddressList(response);
    }

    public List<Addresses> GeocodingControllerCCS(String country, String city, String street) throws IOException, InterruptedException {

        Geocoder geocoder = new Geocoder();
        String response = geocoder.GeocodeCCS(country, city, street);
        return returnAddressList(response);

    }

    public List<Addresses> GeocodingControllerCSC(String country, String state, String city) throws IOException, InterruptedException {

        Geocoder geocoder = new Geocoder();
        String response = geocoder.GeocodeCSC(country, state, city);
        return returnAddressList(response);

    }

    public List<Addresses> GeocodingControllerPostalCode(String postalCode) throws IOException, InterruptedException {
        Geocoder geocoder = new Geocoder();
        String response = geocoder.GeocodePostalCode(postalCode);
        return returnAddressList(response);
    }

    public List<Addresses> returnAddressList(String response) throws JsonProcessingException {
        List<Addresses> addressesList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode responseJsonNode = mapper.readTree(response);
        JsonNode items = responseJsonNode.get("items");

        for (JsonNode item : items) {
            JsonNode address = item.get("address");
            String label = address.get("label").asText();
            JsonNode position = item.get("position");

            String lat = position.get("lat").asText();
            String lng = position.get("lng").asText();
            addressesList.add(new Addresses(label + " is located at " + lat + "," + lng + "."));
        }

        return addressesList;
    }

}
