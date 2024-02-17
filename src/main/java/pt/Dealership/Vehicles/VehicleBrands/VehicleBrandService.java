package pt.Dealership.Vehicles.VehicleBrands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.Common.controllers.ServiceBase;

@Service
public class VehicleBrandService extends ServiceBase<VehicleBrand, Long, VehicleBrandRepository> {

    @Autowired
    private VehicleBrandRepository repository;

    @Override
    protected VehicleBrandRepository getRepository() {
        return repository;
    }

    @Override
    protected void updateEntityProperties(VehicleBrand updatedBody, VehicleBrand entityToUpdate) {

    }

    public VehicleBrand getByName(String name) {
        return repository.findByName(name).orElse(null);
    }
}
