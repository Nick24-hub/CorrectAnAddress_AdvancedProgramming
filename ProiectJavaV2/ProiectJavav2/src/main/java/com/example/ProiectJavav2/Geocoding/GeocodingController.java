package com.example.ProiectJavav2.Geocoding;

import com.example.ProiectJavav2.Address.Addresses;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class GeocodingController {
    private Locale locale = Locale.getDefault();

    public GeocodingController(Locale locale)
    {
        this.locale=locale;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

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

    public String createLabel(JsonNode address, ResourceBundle messages)
    {
        String label = "";
        String[] words = address.get("label").asText().split(" ");
        words[0]=messages.getString("str");
        for(String x:words)
        {
            label+=x;
            label+=" ";
        }

        return label;
    }

    public List<Addresses> returnAddressList(String response) throws JsonProcessingException {
        List<Addresses> addressesList = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode responseJsonNode = mapper.readTree(response);
        JsonNode items = responseJsonNode.get("items");
        ResourceBundle messages = ResourceBundle.getBundle("Messages", locale);

        for (JsonNode item : items) {
            JsonNode address = item.get("address");
            String label = createLabel(address,messages);

            JsonNode position = item.get("position");

            String lat = position.get("lat").asText();
            String lng = position.get("lng").asText();
            addressesList.add(new Addresses(label + " " + messages.getString("response") + " " + lat + "," + lng + "."));
        }

        return addressesList;
    }

}
