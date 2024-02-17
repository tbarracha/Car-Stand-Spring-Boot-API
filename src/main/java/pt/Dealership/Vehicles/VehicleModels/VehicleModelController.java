package pt.Dealership.Vehicles.VehicleModels;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.Common.controllers.ControllerBase;
import pt.Common.entities.GenericDTO;

import java.util.List;

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
        getService().create(1, "A1");
        getService().create(1, "A2");
        getService().create(1, "A3");

        getService().create(2, "B1");
        getService().create(2, "B2");
        getService().create(2, "B3");
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
