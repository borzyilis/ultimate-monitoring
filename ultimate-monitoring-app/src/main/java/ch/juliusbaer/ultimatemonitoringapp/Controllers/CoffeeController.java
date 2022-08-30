package ch.juliusbaer.ultimatemonitoringapp.Controllers;

import ch.juliusbaer.ultimatemonitoringapp.Models.Address;
import ch.juliusbaer.ultimatemonitoringapp.Models.Coffee;
import ch.juliusbaer.ultimatemonitoringapp.Services.CoffeeService;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import io.prometheus.client.Histogram;
import io.prometheus.client.Summary;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoffeeController {

    private final Counter requestCount;
    // private final Summary requestLatency;

    private final Histogram myHistogram;

    public CoffeeController(CollectorRegistry collectorRegistry) {
        requestCount = Counter.build()
                .name("request_coffee_counter")
                .help("Total requests to coffee")
                .register(collectorRegistry);
        /*
        requestLatency = Summary.build()
                .name("requests_coffee_latency_seconds")
                .help("request latency in seconds")
                .register(collectorRegistry);

         */
        myHistogram = Histogram.build()
                .name("requests_coffee_latency_seconds")
                .help("Request latency in seconds")
                .buckets(0.1D, 0.25D,0.5D, 1D, 2D, 4D, 8D, 16D)
                .register(collectorRegistry);
    }

    @Autowired
    private CoffeeService coffeeService;

    @Operation(summary = "Returns a list of coffees")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coffees found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Coffee.class))})})
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

