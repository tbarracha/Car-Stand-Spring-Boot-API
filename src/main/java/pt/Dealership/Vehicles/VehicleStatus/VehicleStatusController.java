package pt.Dealership.Vehicles.VehicleStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.Common.controllers.ControllerBase;
import pt.Common.entities.GenericDTO;

@RestController
@RequestMapping("/api/vehicle/status")
public class VehicleStatusController extends ControllerBase<VehicleStatus, Long, VehicleStatusService> {

    @Autowired
    private VehicleStatusService service;

    @Override
    protected VehicleStatusService getService() {
        return service;
    }

    @Override
    protected void populate() {
        service.create(new VehicleStatus("car"));
        service.create(new VehicleStatus("motorbike"));
    }

    @GetMapping(value = "/name/{name}", produces = "application/json")
    public ResponseEntity<GenericDTO<VehicleStatus>> getByName(@PathVariable("name") String name) {
        VehicleStatus entity = service.getByName(name);
        GenericDTO<VehicleStatus> dto = addLinks(entity, true, true, true, true);
        return httpOkOrNotFound(dto);
    }
}
