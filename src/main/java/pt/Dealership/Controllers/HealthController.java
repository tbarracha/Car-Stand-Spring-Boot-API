package pt.Dealership.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/health")
public class HealthController {

    @GetMapping(produces = "application/json")
    public ResponseEntity<String> greeting() {
        return new ResponseEntity<>("Api is working fine!", HttpStatus.OK);
    }
}
