package pt.Dealership.Models.Vehicles.LicensePlates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.Common.controllers.ControllerBase;

@Order(1)
@RestController
@RequestMapping("api/vehicle/licenseplate")
public class LicensePlateController extends ControllerBase<LicensePlate, Long, LicensePlateService> {

    @Autowired
    private LicensePlateService service;

    @Override
    protected LicensePlateService getService() {
        return service;
    }

    @Override
    protected void populate() {
        getService().create(new LicensePlate("AB-12-34"));
        getService().create(new LicensePlate("CD-56-78"));
        getService().create(new LicensePlate("EF-90-12"));
        getService().create(new LicensePlate("GH-34-56"));
        getService().create(new LicensePlate("IJ-78-90"));
        getService().create(new LicensePlate("KL-12-34"));
        getService().create(new LicensePlate("MN-56-78"));
        getService().create(new LicensePlate("OP-90-12"));
        getService().create(new LicensePlate("QR-34-56"));
        getService().create(new LicensePlate("ST-78-90"));
        getService().create(new LicensePlate("UV-12-34"));
        getService().create(new LicensePlate("WX-56-78"));
        getService().create(new LicensePlate("YZ-90-12"));
    }
}
