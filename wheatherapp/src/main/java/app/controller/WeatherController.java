package app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Facundo on 9/30/2017.
 */
@RestController
public class WeatherController {

    @RequestMapping(method = RequestMethod.GET, value = "/convertToCelsius/{gradosFahrenheit}")
    public ResponseEntity convertToCelsius(@PathVariable Double gradosFahrenheit){
        Double gradosCelsius =  (gradosFahrenheit - 32.0) * (5.0/9.0);
        return new ResponseEntity(gradosCelsius, HttpStatus.OK);
    }


}