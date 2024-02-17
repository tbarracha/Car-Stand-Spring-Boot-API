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
        getService().create(new VehicleStatus("Unknown"));
        getService().create(new VehicleStatus("Avaliable"));
        getService().create(new VehicleStatus("Sold"));
        getService().create(new VehicleStatus("In Repair"));
    }

    @GetMapping(value = "/name/{name}", produces = "application/json")
    public ResponseEntity<GenericDTO<VehicleStatus>> getByName(@PathVariable("name") String name) {
        VehicleStatus entity = getService().getByName(name);
        GenericDTO<VehicleStatus> dto = addAllLinks(entity);
        return httpOkOrNotFound(dto);
    }
}
