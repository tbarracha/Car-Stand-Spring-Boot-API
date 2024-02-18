package pt.Dealership.Models.Vehicles.LicensePlates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.Common.controllers.ServiceBase;

@Service
public class LicensePlateService extends ServiceBase<LicensePlate, Long, LicensePlateRepository> {

    @Autowired
    LicensePlateRepository repository;

    @Override
    protected LicensePlateRepository getRepository() {
        return repository;
    }

    @Override
    protected void updateEntityProperties(LicensePlate updatedBody, LicensePlate entityToUpdate) {

    }

    @Override
    protected LicensePlate tryGetEntity(LicensePlate body) {
        return null;
    }

    public LicensePlate getByName(String content) {
        return repository.findByName(content).orElse(null);
    }
}
