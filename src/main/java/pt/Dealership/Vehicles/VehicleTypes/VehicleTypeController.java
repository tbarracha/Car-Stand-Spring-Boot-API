package pt.Dealership.Vehicles.VehicleTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.Common.controllers.ControllerBase;
import pt.Common.entities.GenericDTO;

@RestController
@RequestMapping("/api/vtype")
public class VehicleTypeController extends ControllerBase<VehicleType, Long, VehicleTypeService> {

    @Autowired
    private VehicleTypeService service;

    @Override
    protected VehicleTypeService getService() {
        return service;
    }

    @Override
    protected void populate() {
        service.create(new VehicleType("car"));
        service.create(new VehicleType("motorbike"));
    }

    @GetMapping(value = "/name/{name}", produces = "application/json")
    public ResponseEntity<GenericDTO<VehicleType>> getByName(@PathVariable("name") String name) {
        VehicleType entity = service.getByName(name);
        GenericDTO<VehicleType> dto = addLinks(entity, true, true, true, true);
        return httpOkOrNotFound(dto);
    }
}
