# CorrectAnAddress_AdvancedProgramming

CorrectAnAddress is an aplication design to  take diferent types of request and give you an answer with all possible addresses which match your request.
This project was made by a two people team consisting of Alecandrescu Nicolae and Vacaru Stefan Robert.

### Contributions of Vacaru Stefan Robert:
 1.Communication with the Geocoding API found at: [API](https://developer.here.com/documentation/geocoding-search-api/api-reference-swagger.html?fbclid=IwAR3AxCgm1-ik0Tm_B_U0A4-kkfjJKDTK-fAMrWrfAqPTRXRfHdGeiC4QP8w)
 
 2.REST Services:
   * A service named "Any" in which you can enter a simple query in format {param1,param2,...} and it will correct the address that you have entered and return  some choices.
   * A service named "CCS" in which you enter a qualified query in format {country}={nameOfTheCountry},{city}={nameOfTheCity},{street=nameOfTheStreet} and it will correct the address that you have entered and return  some choices.
   * A service named "Coordinates" in which you enter a simple query like the one at "Any" and it will return the latitude and longitude of that specific location.
   * A service named "AddressByCoordinates" in which you enter specific coordinates by longitude and latitude and it will return the closest addresses to that coordinates.
   
### Contributions of Alexandrescu Nicolae:
1.Rest Services :
  * A service named "CSC" in which you enter a qualified query in format {country}={nameOfTheCountry},{state}={nameOfTheState},{city=nameOfTheCity} and it will correct the address that you have entered and return  some choices.
  * A service named "PostalCode" in which you enter a postal code and it will return the possible addresses for that specific postal code.  
  
2.Internationalization of the application which consists on translating  the responses of the services in 4 languages.
    
