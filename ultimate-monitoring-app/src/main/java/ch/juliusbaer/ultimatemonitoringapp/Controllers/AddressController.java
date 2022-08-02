package ch.juliusbaer.ultimatemonitoringapp.Controllers;

import ch.juliusbaer.ultimatemonitoringapp.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/addresses")
    public String fetchAddresses(Model model) {
        model.addAttribute("addresses", addressService.getAddresses());
        return "addresses";
    }

}
