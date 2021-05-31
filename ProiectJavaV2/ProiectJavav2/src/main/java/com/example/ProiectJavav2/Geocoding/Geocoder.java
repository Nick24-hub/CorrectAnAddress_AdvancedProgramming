package com.example.ProiectJavav2.Geocoding;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

public class Geocoder {

    private static final String GEOCODING_RESOURCE = "https://geocode.search.hereapi.com/v1/geocode";
    private static final String API_KEY = "lqZzdme-Zq1ddipftXQZeZWzI7Rv5dOpUwk8TBQNFg8";

    public String GeocodeCCS(String country, String city, String street) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();
        String query = "country" + "=" + country + ";"
                + "city" + "=" + city + ";"
                + "street" + "=" + street;
        return getResponseQualifiedQuery(httpClient, query);
    }

    public String GeocodeCSC(String country, String state, String city) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();
        String query = "country" + "=" + country + ";"
                + "state" + "=" + state + ";"
                + "city" + "=" + city;
        return getResponseQualifiedQuery(httpClient, query);
    }

    public String GeocodePostalCode(String postalCode) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();
        String query = "postalCode" + "=" + postalCode;
        return getResponseQualifiedQuery(httpClient, query);
    }
    public String GeocodeAny(String query) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();
        return getResponseQuery(httpClient,query);
    }
    public String GeocodeCoordinates(String lat,String lng) throws IOException, InterruptedException {

        HttpClient httpClient = HttpClient.newHttpClient();
        return getResponseCoordinates(httpClient,lat,lng);
    }
    private String getResponseQualifiedQuery(HttpClient httpClient, String query) throws IOException, InterruptedException {
        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
        String requestUri = GEOCODING_RESOURCE + "?apiKey=" + API_KEY + "&qq=" + encodedQuery;

        HttpRequest geocodingRequest = HttpRequest.newBuilder().GET().uri(URI.create(requestUri))
                .timeout(Duration.ofMillis(2000)).build();

        HttpResponse<String> geocodingResponse = httpClient.send(geocodingRequest,
                HttpResponse.BodyHandlers.ofString());

        return geocodingResponse.body();
    }


    public String getResponseQuery(HttpClient httpClient,String query) throws IOException, InterruptedException {
        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
        String requestUri = GEOCODING_RESOURCE + "?apiKey=" + API_KEY + "&q=" + encodedQuery;

        HttpRequest geocodingRequest = HttpRequest.newBuilder().GET().uri(URI.create(requestUri))
                .timeout(Duration.ofMillis(2000)).build();

        HttpResponse<String> geocodingResponse = httpClient.send(geocodingRequest,
                HttpResponse.BodyHandlers.ofString());

        return geocodingResponse.body();
    }
    public String getResponseCoordinates(HttpClient httpClient,String lat,String lng) throws IOException, InterruptedException {
        String query=lat+","+lng;
        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8);
        String browse="https://geocode.search.hereapi.com/v1/browse";
        String requestUri = browse + "?apiKey=" + API_KEY + "&at=" + encodedQuery;

        HttpRequest geocodingRequest = HttpRequest.newBuilder().GET().uri(URI.create(requestUri))
                .timeout(Duration.ofMillis(2000)).build();

        HttpResponse<String> geocodingResponse = httpClient.send(geocodingRequest,
                HttpResponse.BodyHandlers.ofString());

        return geocodingResponse.body();
    }




}