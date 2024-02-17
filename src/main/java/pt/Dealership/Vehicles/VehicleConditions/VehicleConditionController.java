package pt.Dealership.Vehicles.VehicleConditions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.Common.controllers.ControllerBase;
import pt.Common.entities.GenericDTO;

@RestController
@RequestMapping("/api/vehicle/condition")
public class VehicleConditionController extends ControllerBase<VehicleCondition, Long, VehicleConditionService> {

    @Autowired
    private VehicleConditionService service;

    @Override
    protected VehicleConditionService getService() {
        return service;
    }

    @Override
    protected void populate() {
        getService().create(new VehicleCondition("New"));
        getService().create(new VehicleCondition("Used"));
        getService().create(new VehicleCondition("Refurbished"));
    }

    @GetMapping(value = "/name/{name}", produces = "application/json")
    public ResponseEntity<GenericDTO<VehicleCondition>> getByName(@PathVariable("name") String name) {
        VehicleCondition entity = getService().getByName(name);
        GenericDTO<VehicleCondition> dto = addAllLinks(entity);
        return httpOkOrNotFound(dto);
    }
}
