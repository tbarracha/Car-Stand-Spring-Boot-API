package pt.carstand.CarStand.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.carstand.CarStand.Data.LogRepository;
import pt.carstand.CarStand.Models.Log;

@RestController
@RequestMapping("/api")
public class GreetingsController {

    @Autowired
    LogRepository logRepository;

    @GetMapping(value = "/greeting", produces = "application/json")
    public ResponseEntity<String> greeting() {
        return new ResponseEntity<>("Api is working fine!", HttpStatus.OK);
    }

    @PostMapping(value = "/log", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Log> postLog(@RequestBody Log log) {
        logRepository.save(log);
        return new ResponseEntity<>(log, HttpStatus.OK);
    }
}
