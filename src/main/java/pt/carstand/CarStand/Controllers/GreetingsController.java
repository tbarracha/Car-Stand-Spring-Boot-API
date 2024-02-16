package pt.carstand.CarStand.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.carstand.CarStand.Data.LogRepository;

@RestController
@RequestMapping("/api/greeting")
public class GreetingsController {

    @Autowired
    LogRepository logRepository;

    @GetMapping(produces = "application/json")
    public ResponseEntity<String> greeting() {
        return new ResponseEntity<>("Api is working fine!", HttpStatus.OK);
    }

}
