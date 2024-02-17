package pt.Dealership.Vehicles.VehicleStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.Common.controllers.ServiceBase;

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

    public VehicleStatus getByName(String name) {
        return repository.findByName(name).orElse(null);
    }
}
