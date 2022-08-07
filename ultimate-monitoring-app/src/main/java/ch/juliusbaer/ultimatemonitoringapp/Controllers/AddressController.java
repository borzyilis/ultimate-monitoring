package ch.juliusbaer.ultimatemonitoringapp.Controllers;

import ch.juliusbaer.ultimatemonitoringapp.Services.AddressService;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AddressController {

    private final Counter requestCount;

    public AddressController(CollectorRegistry collectorRegistry){
        requestCount = Counter.build()
                .name("request_address_counter")
                .help("Total requests to address")
                .register(collectorRegistry);
    }

    @Autowired
    private AddressService addressService;

    @GetMapping("/addresses")
    public String fetchAddresses(Model model) {
        model.addAttribute("addresses", addressService.getAddresses());
        requestCount.inc();
        return "addresses";
    }

}
