package pt.Dealership.Models.Vehicles.VehicleTypes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.Common.controllers.ServiceBase;

@Service
public class VehicleTypeService extends ServiceBase<VehicleType, Long, VehicleTypeRepository> {

    @Autowired
    private VehicleTypeRepository repository;

    @Override
    protected VehicleTypeRepository getRepository() {
        return repository;
    }

    @Override
    protected void updateEntityProperties(VehicleType updatedBody, VehicleType entityToUpdate) {

    }

    public VehicleType getByName(String name) {
        return repository.findByName(name).orElse(null);
    }
}
