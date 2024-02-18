package pt.Dealership.Models.Vehicles.VehicleBrands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
        getService().create(new VehicleBrand("Volvo"));
        getService().create(new VehicleBrand("Toyota"));
        getService().create(new VehicleBrand("Mercedes-Benz"));
        getService().create(new VehicleBrand("Ford"));
        getService().create(new VehicleBrand("Chevrolet"));
        getService().create(new VehicleBrand("Honda"));
        getService().create(new VehicleBrand("Hyundai"));
        getService().create(new VehicleBrand("Volkswagen"));
        getService().create(new VehicleBrand("Nissan"));
        getService().create(new VehicleBrand("Subaru"));
    }


    @GetMapping(value = "/name/{name}", produces = "application/json")
    public ResponseEntity<GenericDTO<VehicleBrand>> getByName(@PathVariable("name") String name) {
        VehicleBrand entity = getService().getByName(name);
        GenericDTO<VehicleBrand> dto = addAllLinks(entity);
        return httpOkOrNotFound(dto);
    }

    /*
    //@Override
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<GenericDTO<VehicleBrand>> create(String name) {
        VehicleBrand brand = new VehicleBrand(name);
        return create(brand);
    }

     */
}
