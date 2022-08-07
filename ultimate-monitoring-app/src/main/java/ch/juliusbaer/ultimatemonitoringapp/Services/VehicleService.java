package ch.juliusbaer.ultimatemonitoringapp.Services;

import ch.juliusbaer.ultimatemonitoringapp.Models.Coffee;
import ch.juliusbaer.ultimatemonitoringapp.Models.Vehicle;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VehicleService {

    private final RestTemplate restTemplate;
    private final String URL = "https://random-data-api.com/api/vehicle/random_vehicle?size=30";

    public VehicleService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public Vehicle[] getVehicles(){
        return this.restTemplate.getForObject(URL, Vehicle[].class);
    }
}
