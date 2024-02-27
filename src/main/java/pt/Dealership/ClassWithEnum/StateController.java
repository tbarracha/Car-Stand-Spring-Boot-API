package pt.Dealership.ClassWithEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/state")
public class StateController {

    @Autowired
    StateRepository repository;

    private State createOrGetState(String stateName, StateEnum stateEnum) {
        State state = repository.findByName(stateName).orElse(null);

        if (state == null) {
            state = new State(stateName, stateEnum);
            repository.save(state);
        }

        return state;
    }

    @PostMapping()
    public State createState(@RequestParam String stateName, @RequestParam StateEnum stateEnum) {
        return createOrGetState(stateName, stateEnum);
    }

    @GetMapping()
    public State getState(@RequestParam int stateId) {
        return repository.findById(stateId).orElse(null);
    }
}
