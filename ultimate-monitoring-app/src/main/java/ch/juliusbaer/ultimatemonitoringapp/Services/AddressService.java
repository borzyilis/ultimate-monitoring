package ch.juliusbaer.ultimatemonitoringapp.Services;

import ch.juliusbaer.ultimatemonitoringapp.Models.Address;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AddressService {
    private final RestTemplate restTemplate;
    private final String URL = "https://random-data-api.com/api/address/random_address?size=30";

    public AddressService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    public Address[] getAddresses(){
        return this.restTemplate.getForObject(URL, Address[].class);
    }
}

