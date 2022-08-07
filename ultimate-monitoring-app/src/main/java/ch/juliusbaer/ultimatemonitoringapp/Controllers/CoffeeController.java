package ch.juliusbaer.ultimatemonitoringapp.Controllers;

import ch.juliusbaer.ultimatemonitoringapp.Services.AddressService;
import ch.juliusbaer.ultimatemonitoringapp.Services.CoffeeService;
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
public class CoffeeController {

    private final Counter requestCount;

    public CoffeeController(CollectorRegistry collectorRegistry){
        requestCount = Counter.build()
                .name("request_coffee_counter")
                .help("Total requests to coffee")
                .register(collectorRegistry);
    }

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/coffees")
    public String fetchCoffees(Model model) {
        model.addAttribute("coffees", coffeeService.getCoffees());
        requestCount.inc();
        return "coffees";
    }

}

