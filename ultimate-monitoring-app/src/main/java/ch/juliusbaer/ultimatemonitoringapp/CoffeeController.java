package ch.juliusbaer.ultimatemonitoringapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeController {

    @Autowired
    private CoffeeService coffeeService;

    @GetMapping("/coffees")
    public ResponseEntity<?> fetchAllCoffees() {
        return ResponseEntity.status(HttpStatus.OK).body(coffeeService.getCoffeesAsJSON());
    }

}

