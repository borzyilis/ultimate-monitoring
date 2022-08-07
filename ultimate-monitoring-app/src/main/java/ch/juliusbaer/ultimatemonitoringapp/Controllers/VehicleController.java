package ch.juliusbaer.ultimatemonitoringapp.Controllers;

import ch.juliusbaer.ultimatemonitoringapp.Models.Vehicle;
import ch.juliusbaer.ultimatemonitoringapp.Services.AddressService;
import ch.juliusbaer.ultimatemonitoringapp.Services.VehicleService;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;

@Controller
public class VehicleController {

    private final Counter requestCount;
    private String delim = ",";
    private Vehicle[] vehicles;
    String carOptions;

    public VehicleController(CollectorRegistry collectorRegistry){
        requestCount = Counter.build()
                .name("request_vehicle_counter")
                .help("Total requests to vehicle")
                .register(collectorRegistry);
    }

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicles")
    public String fetchVehicles(Model model) {
        model.addAttribute("vehicles", vehicleService.getVehicles());
        vehicles = vehicleService.getVehicles();
        requestCount.inc();
        return "vehicles";
    }

    /*
    TODO: String array of car options as String, as th:each doesnt work with <td> tag.
    @ModelAttribute("allVehicleOptions")public String populateVehicleOptions(@ModelAttribute Vehicle vehicle) {

        return vehicle.getCar_type();
    }
     */

}
