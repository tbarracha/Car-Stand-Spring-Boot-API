package pt.Dealership.Vehicles.VehicleBrands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.Common.controllers.ControllerBase;
import pt.Common.entities.GenericDTO;

@RestController
@RequestMapping("/api/vehicle/brand")
public class VehicleBrandController extends ControllerBase<VehicleBrand, Long, VehicleBrandService> {

    @Autowired
    private VehicleBrandService service;

    @Override
    protected VehicleBrandService getService() {
        return service;
    }

    @Override
    protected void populate() {
        service.create(new VehicleBrand("car"));
        service.create(new VehicleBrand("motorbike"));
    }

    @GetMapping(value = "/name/{name}", produces = "application/json")
    public ResponseEntity<GenericDTO<VehicleBrand>> getByName(@PathVariable("name") String name) {
        VehicleBrand entity = service.getByName(name);
        GenericDTO<VehicleBrand> dto = addLinks(entity, true, true, true, true);
        return httpOkOrNotFound(dto);
    }
}
