package com.example.ProiectJavav2.Services;

import com.example.ProiectJavav2.Address.AddressesList;
import com.example.ProiectJavav2.Geocoding.GeocodingController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Locale;


@RestController
@RequestMapping({"/Search/fr"})
public class ServiceControllerFr {

    private Locale locale = new Locale("fr");

    @GetMapping({"/Any"})
    public ResponseEntity<AddressesList> getAddressAny(@RequestParam String address) throws IOException, InterruptedException {
        GeocodingController geocodingController = new GeocodingController(locale);
        AddressesList addressesList = new AddressesList(geocodingController.GeocodingControllerAny(address));
        return new ResponseEntity<>(addressesList, HttpStatus.OK);
    }

    @GetMapping({"/CCS"})
    public ResponseEntity<AddressesList> getAddressCCS(@RequestParam String country, @RequestParam String city, @RequestParam String street) throws IOException, InterruptedException {
        GeocodingController geocodingController = new GeocodingController(locale);
        AddressesList addressesList = new AddressesList(geocodingController.GeocodingControllerCCS(country, city, street));
        return new ResponseEntity<>(addressesList, HttpStatus.OK);
    }

    @GetMapping({"/PostalCode"})
    public ResponseEntity<AddressesList> getAddressPostal(@RequestParam String postalCode) throws IOException, InterruptedException {
        GeocodingController geocodingController = new GeocodingController(locale);
        AddressesList addressesList = new AddressesList(geocodingController.GeocodingControllerPostalCode(postalCode));
        return new ResponseEntity<>(addressesList, HttpStatus.OK);
    }

    @GetMapping({"/CSC"})
    public ResponseEntity<AddressesList> getAddressCSC(@RequestParam String country, @RequestParam String state, @RequestParam String city) throws IOException, InterruptedException {
        GeocodingController geocodingController = new GeocodingController(locale);
        AddressesList addressesList = new AddressesList(geocodingController.GeocodingControllerCSC(country, state, city));
        return new ResponseEntity<>(addressesList, HttpStatus.OK);
    }
    @GetMapping({"/Coordinates"})
    public ResponseEntity<AddressesList> getAddressCoordinates(@RequestParam String address) throws IOException, InterruptedException {
        GeocodingController geocodingController = new GeocodingController(locale);
        AddressesList addressesList = new AddressesList(geocodingController.GeocodingControllerCoordinates(address));
        return new ResponseEntity<>(addressesList, HttpStatus.OK);
    }
    @GetMapping({"/CoordinatesByAddress"})
    public ResponseEntity<AddressesList> getAddressByCoordinates(@RequestParam String lat,@RequestParam String lng) throws IOException, InterruptedException {
        GeocodingController geocodingController = new GeocodingController(locale);
        AddressesList addressesList = new AddressesList(geocodingController.GeocodingControllerAddressByCoordinates(lat,lng));
        return new ResponseEntity<>(addressesList, HttpStatus.OK);
    }
}

