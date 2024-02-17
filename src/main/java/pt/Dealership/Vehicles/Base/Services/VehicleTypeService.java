package pt.Dealership.Vehicles.Base.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.Dealership.Vehicles.Base.Data.VehicleTypeRepository;
import pt.Dealership.Vehicles.Base.Models.VehicleType;
import pt.Dealership.base.controllers.ServiceBase;

import java.util.List;

@Service
public class VehicleTypeService extends ServiceBase<VehicleType, Long, VehicleTypeRepository> {

    @Autowired
    private VehicleTypeRepository repository;

    @Override
    public VehicleTypeRepository getRepository() {
        return repository;
    }

    public VehicleType getByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    // Create & Update
    @Override
    public VehicleType create(VehicleType body) {
        try {
            return repository.save(body);
        } catch (Exception e) {
            System.out.println("Vehicle already exists!");
            return getByName(body.getName());
        }
    }

    public VehicleType create(String name) {
        VehicleType body = new VehicleType(name);
        return create(body);
    }


    @Override
    protected void updateEntityProperties(VehicleType body, VehicleType entity) {
        System.out.println("Updated entity!");
    }
}
