package pt.carstand.CarStand.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/greeting")
public class GreetingsController {

    @GetMapping(produces = "application/json")
    public ResponseEntity<String> greeting() {
        return new ResponseEntity<>("Api is working fine!", HttpStatus.OK);
    }

}
