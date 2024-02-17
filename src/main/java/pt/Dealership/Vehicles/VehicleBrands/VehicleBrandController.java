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
        getService().create(new VehicleBrand("Audi"));
        getService().create(new VehicleBrand("BMW"));
        getService().create(new VehicleBrand("Tesla"));
        getService().create(new VehicleBrand("Volco"));
    }

    @GetMapping(value = "/name/{name}", produces = "application/json")
    public ResponseEntity<GenericDTO<VehicleBrand>> getByName(@PathVariable("name") String name) {
        VehicleBrand entity = getService().getByName(name);
        GenericDTO<VehicleBrand> dto = addAllLinks(entity);
        return httpOkOrNotFound(dto);
    }
}
