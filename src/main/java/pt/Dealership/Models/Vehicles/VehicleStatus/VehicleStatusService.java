package pt.Dealership.Models.Vehicles.VehicleStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.Common.controllers.ServiceBase;
import pt.Dealership.Models.Cars.Car;

@Service
public class VehicleStatusService extends ServiceBase<VehicleStatus, Long, VehicleStatusRepository> {

    @Autowired
    private VehicleStatusRepository repository;

    @Override
    protected VehicleStatusRepository getRepository() {
        return repository;
    }

    @Override
    protected void updateEntityProperties(VehicleStatus updatedBody, VehicleStatus entityToUpdate) {

    }

    @Override
    protected VehicleStatus tryGetEntity(VehicleStatus body) {
        return null;
    }

    public VehicleStatus getByName(String name) {
        return repository.findByName(name).orElse(null);
    }
}
