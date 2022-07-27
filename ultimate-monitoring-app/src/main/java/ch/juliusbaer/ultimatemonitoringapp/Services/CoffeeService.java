package ch.juliusbaer.ultimatemonitoringapp.Services;

import ch.juliusbaer.ultimatemonitoringapp.Models.Coffee;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class CoffeeService {
    private final RestTemplate restTemplate;
    private final String URL = "https://random-data-api.com/api/coffee/random_coffee?size=30";

    public CoffeeService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public Coffee[] getCoffees(){
        return this.restTemplate.getForObject(URL, Coffee[].class);
    }
}
