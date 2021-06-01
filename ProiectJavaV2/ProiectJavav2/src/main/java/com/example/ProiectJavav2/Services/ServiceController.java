package com.example.ProiectJavav2.Services;

import com.example.ProiectJavav2.Address.AddressesList;
import com.example.ProiectJavav2.Geocoding.GeocodingController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Locale;

public class ServiceController {

    public ResponseEntity<AddressesList> getAddressAny(Locale locale, String address) throws IOException, InterruptedException {
        GeocodingController geocodingController = new GeocodingController(locale);
        AddressesList addressesList = new AddressesList(geocodingController.GeocodingControllerAny(address));
        return new ResponseEntity<>(addressesList, HttpStatus.OK);
    }


    public ResponseEntity<AddressesList> getAddressCCS(Locale locale, String country, String city, String street) throws IOException, InterruptedException {
        GeocodingController geocodingController = new GeocodingController(locale);
        AddressesList addressesList = new AddressesList(geocodingController.GeocodingControllerCCS(country, city, street));
        return new ResponseEntity<>(addressesList, HttpStatus.OK);
    }


    public ResponseEntity<AddressesList> getAddressPostal(Locale locale, String postalCode) throws IOException, InterruptedException {
        GeocodingController geocodingController = new GeocodingController(locale);
        AddressesList addressesList = new AddressesList(geocodingController.GeocodingControllerPostalCode(postalCode));
        return new ResponseEntity<>(addressesList, HttpStatus.OK);
    }


    public ResponseEntity<AddressesList> getAddressCSC(Locale locale, String country, String state, String city) throws IOException, InterruptedException {
        GeocodingController geocodingController = new GeocodingController(locale);
        AddressesList addressesList = new AddressesList(geocodingController.GeocodingControllerCSC(country, state, city));
        return new ResponseEntity<>(addressesList, HttpStatus.OK);
    }

    public ResponseEntity<AddressesList> getAddressCoordinates(Locale locale, String address) throws IOException, InterruptedException {
        GeocodingController geocodingController = new GeocodingController(locale);
        AddressesList addressesList = new AddressesList(geocodingController.GeocodingControllerCoordinates(address));
        return new ResponseEntity<>(addressesList, HttpStatus.OK);
    }

    public ResponseEntity<AddressesList> getAddressByCoordinates(Locale locale, String lat, String lng) throws IOException, InterruptedException {
        GeocodingController geocodingController = new GeocodingController(locale);
        AddressesList addressesList = new AddressesList(geocodingController.GeocodingControllerAddressByCoordinates(lat,lng));
        return new ResponseEntity<>(addressesList, HttpStatus.OK);
    }
}
