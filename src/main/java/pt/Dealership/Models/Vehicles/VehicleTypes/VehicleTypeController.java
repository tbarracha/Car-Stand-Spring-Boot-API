package pt.Dealership.Models.Vehicles.VehicleTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.Common.controllers.ControllerBase;
import pt.Common.entities.GenericDTO;

@RestController
@RequestMapping("/api/vehicle/type")
public class VehicleTypeController extends ControllerBase<VehicleType, Long, VehicleTypeService> {

    @Autowired
    private VehicleTypeService service;

    @Override
    protected VehicleTypeService getService() {
        return service;
    }

    @Override
    protected void populate() {
        getService().create(new VehicleType("VehicleType"));
        getService().create(new VehicleType("Motorbike"));
        getService().create(new VehicleType("Truck"));
        getService().create(new VehicleType("Van"));
        getService().create(new VehicleType("SUV"));
    }

    @GetMapping(value = "/name/{name}", produces = "application/json")
    public ResponseEntity<GenericDTO<VehicleType>> getByName(@PathVariable("name") String name) {
        VehicleType entity = getService().getByName(name);
        GenericDTO<VehicleType> dto = addAllLinks(entity);
        return httpOkOrNotFound(dto);
    }
}
