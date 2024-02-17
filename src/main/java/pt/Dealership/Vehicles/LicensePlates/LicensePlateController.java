package pt.Dealership.Vehicles.LicensePlates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.Common.controllers.ControllerBase;

@RestController
@RequestMapping("api/vehicle/license")
public class LicensePlateController extends ControllerBase<LicensePlate, Long, LicensePlateService> {

    @Autowired
    private LicensePlateService service;

    @Override
    protected LicensePlateService getService() {
        return service;
    }

    @Override
    protected void populate() {
        getService().create(new LicensePlate("123"));
        getService().create(new LicensePlate("456"));
        getService().create(new LicensePlate("789"));
        getService().create(new LicensePlate("321"));
        getService().create(new LicensePlate("654"));
    }
}
