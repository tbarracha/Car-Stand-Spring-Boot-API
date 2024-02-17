package pt.Dealership.Vehicles.VehicleTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.Common.controllers.ControllerBase;

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
}
