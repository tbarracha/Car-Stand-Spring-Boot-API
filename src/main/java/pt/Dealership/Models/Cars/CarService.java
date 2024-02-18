package pt.Dealership.Models.Cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.Common.controllers.ServiceBase;

@Service
public class CarService extends ServiceBase<Car, Long, CarRepository> {

    @Autowired
    private CarRepository repository;

    @Override
    protected CarRepository getRepository() {
        return repository;
    }

    @Override
    protected void updateEntityProperties(Car updatedBody, Car entityToUpdate) {

    }
}
