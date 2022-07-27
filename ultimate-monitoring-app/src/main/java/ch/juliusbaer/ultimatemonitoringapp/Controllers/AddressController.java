package ch.juliusbaer.ultimatemonitoringapp.Controllers;

import ch.juliusbaer.ultimatemonitoringapp.Services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/addresses")
    public ResponseEntity<?> fetchAddresses() {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAddresses());
    }

}
