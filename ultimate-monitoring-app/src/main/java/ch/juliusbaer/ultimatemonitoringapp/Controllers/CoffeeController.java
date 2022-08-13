package ch.juliusbaer.ultimatemonitoringapp.Controllers;

import ch.juliusbaer.ultimatemonitoringapp.Services.CoffeeService;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.Histogram;
import io.prometheus.client.Summary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoffeeController {

    private final Counter requestCount;
    private final Summary requestLatency;

    private final Histogram myHistogram;

    public CoffeeController(CollectorRegistry collectorRegistry) {
        requestCount = Counter.build()
                .name("request_coffee_counter")
                .help("Total requests to coffee")
                .register(collectorRegistry);
        requestLatency = Summary.build()
                .name("requests_coffee_latency_seconds")
                .help("request latency in seconds")
                .register(collectorRegistry);
        myHistogram = Histogram.build()
                .name("API_REQUEST_LATENCY_MILLIS")
                .help("REQUEST_LATENCY_IN_MILLISECONDS")
                .buckets(0.5D, 1D, 2D, 4D, 8D, 12D)
                .register(collectorRegistry);
    }

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/coffees")
    public String fetchCoffees(Model model) {
        Histogram.Timer myTimer = myHistogram.startTimer();
        try{
            model.addAttribute("coffees", coffeeService.getCoffees());
            requestCount.inc();
            return "coffees";
        }
        finally {
            myTimer.observeDuration();
        }


    }

}

