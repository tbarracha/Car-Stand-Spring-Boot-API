package pt.Dealership.Models.Vehicles.VehicleModels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.Common.controllers.ControllerBase;
import pt.Common.entities.GenericDTO;

import java.util.List;

@Order(2)
@RestController
@RequestMapping("/api/vehicle/model")
public class VehicleModelController extends ControllerBase<VehicleModel, Long, VehicleModelService> {

    @Autowired
    private VehicleModelService service;

    @Override
    protected VehicleModelService getService() {
        return service;
    }

    @Override
    protected void populate() {
        System.out.println(this.getClass().getSimpleName() + ", wont populate yet");
    }

    public void populateWithModels() {
        // Audi
        getService().create((long) 1, "A1");
        getService().create((long) 1, "A2");
        getService().create((long) 1, "A3");

        // BMW
        getService().create((long) 2, "1 Series");
        getService().create((long) 2, "2 Series");
        getService().create((long) 2, "3 Series");

        // Tesla
        getService().create((long) 3, "Model S");
        getService().create((long) 3, "Model 3");
        getService().create((long) 3, "Model X");

        // Volvo
        getService().create((long) 4, "S60");
        getService().create((long) 4, "XC40");
        getService().create((long) 4, "XC90");

        // Toyota
        getService().create((long) 5, "Corolla");
        getService().create((long) 5, "Camry");
        getService().create((long) 5, "Rav4");

        // Mercedes-Benz
        getService().create((long) 6, "C-Class");
        getService().create((long) 6, "E-Class");
        getService().create((long) 6, "S-Class");

        // Ford
        getService().create((long) 7, "Fiesta");
        getService().create((long) 7, "Focus");
        getService().create((long) 7, "Mustang");

        // Chevrolet
        getService().create((long) 8, "Camaro");
        getService().create((long) 8, "Silverado");
        getService().create((long) 8, "Malibu");

        // Honda
        getService().create((long) 9, "Civic");
        getService().create((long) 9, "Accord");
        getService().create((long) 9, "CR-V");

        // Hyundai
        getService().create((long) 10, "Elantra");
        getService().create((long) 10, "Sonata");
        getService().create((long) 10, "Tucson");

        // Volkswagen
        getService().create((long) 11, "Golf");
        getService().create((long) 11, "Passat");
        getService().create((long) 11, "Tiguan");

        // Nissan
        getService().create((long) 12, "Altima");
        getService().create((long) 12, "Maxima");
        getService().create((long) 12, "Rogue");

        // Subaru
        getService().create((long) 13, "Impreza");
        getService().create((long) 13, "Outback");
        getService().create((long) 13, "Forester");
    }




    @GetMapping(value = "/name/{name}", produces = "application/json")
    public ResponseEntity<GenericDTO<VehicleModel>> getByName(@PathVariable("name") String name) {
        VehicleModel entity = getService().getByName(name);
        GenericDTO<VehicleModel> dto = addAllLinks(entity);
        return httpOkOrNotFound(dto);
    }

    @GetMapping(value = "/brandId/{brandId}", produces = "application/json")
    public CollectionModel<VehicleModel> getByBrandId(@PathVariable("brandId") long brandId) {
        List<VehicleModel> models = getService().getByBrandId(brandId);
        CollectionModel<VehicleModel> collectionModel = CollectionModel.of(models);
        collectionModel = addLinks(collectionModel, true, true);
        return collectionModel;
    }

    @GetMapping(value = "/brandName/{brandName}", produces = "application/json")
    public CollectionModel<VehicleModel> getByBrandName(@PathVariable("brandName") String brandName) {
        List<VehicleModel> models = getService().getByBrandName(brandName);
        CollectionModel<VehicleModel> collectionModel = CollectionModel.of(models);
        collectionModel = addLinks(collectionModel, true, true);
        return collectionModel;
    }
}
