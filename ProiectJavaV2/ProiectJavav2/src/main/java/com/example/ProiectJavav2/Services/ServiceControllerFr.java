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
public class ServiceControllerFr extends ServiceController {

    private Locale locale = new Locale("fr");

    @GetMapping({"/Any"})
    public ResponseEntity<AddressesList> getAddressAny(@RequestParam String address) throws IOException, InterruptedException {
        return super.getAddressAny(locale, address);
    }

    @GetMapping({"/CCS"})
    public ResponseEntity<AddressesList> getAddressCCS(@RequestParam String country, @RequestParam String city, @RequestParam String street) throws IOException, InterruptedException {
        return super.getAddressCCS(locale, country, city, street);
    }

    @GetMapping({"/PostalCode"})
    public ResponseEntity<AddressesList> getAddressPostal(@RequestParam String postalCode) throws IOException, InterruptedException {
        return super.getAddressPostal(locale, postalCode);
    }

    @GetMapping({"/CSC"})
    public ResponseEntity<AddressesList> getAddressCSC(@RequestParam String country, @RequestParam String state, @RequestParam String city) throws IOException, InterruptedException {
        return super.getAddressCSC(locale, country, state, city);
    }

    @GetMapping({"/Coordinates"})
    public ResponseEntity<AddressesList> getAddressCoordinates(@RequestParam String address) throws IOException, InterruptedException {
        return super.getAddressCoordinates(locale, address);
    }

    @GetMapping({"/CoordinatesByAddress"})
    public ResponseEntity<AddressesList> getAddressByCoordinates(@RequestParam String lat, @RequestParam String lng) throws IOException, InterruptedException {
        return super.getAddressByCoordinates(locale, lat, lng);
    }
}

