package pt.Dealership.Vehicles.VehicleConditions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.Common.controllers.ServiceBase;

@Service
public class VehicleConditionService extends ServiceBase<VehicleCondition, Long, VehicleConditionRepository> {

    @Autowired
    private VehicleConditionRepository repository;

    @Override
    protected VehicleConditionRepository getRepository() {
        return repository;
    }

    @Override
    protected void updateEntityProperties(VehicleCondition updatedBody, VehicleCondition entityToUpdate) {

    }

    public VehicleCondition getByName(String name) {
        return repository.findByName(name).orElse(null);
    }
}
