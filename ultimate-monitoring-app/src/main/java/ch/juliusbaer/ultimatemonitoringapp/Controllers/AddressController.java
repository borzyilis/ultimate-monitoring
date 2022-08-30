package ch.juliusbaer.ultimatemonitoringapp.Controllers;

import ch.juliusbaer.ultimatemonitoringapp.Models.Address;
import ch.juliusbaer.ultimatemonitoringapp.Services.AddressService;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
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

    @Operation(summary = "Returns a list of addresses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Address found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = Address.class))})})
    @GetMapping("/addresses")
    public String fetchAddresses(Model model) {
        model.addAttribute("addresses", addressService.getAddresses());
        requestCount.inc();
        return "addresses";
    }

}
