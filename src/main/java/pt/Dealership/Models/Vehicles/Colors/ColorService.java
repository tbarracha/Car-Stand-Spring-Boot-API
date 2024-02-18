package pt.Dealership.Models.Vehicles.Colors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.Common.controllers.ServiceBase;
import pt.Dealership.Models.Cars.Car;

@Service
public class ColorService extends ServiceBase<Color, Long, ColorRepository> {

    @Autowired
    ColorRepository repository;

    @Override
    protected ColorRepository getRepository() {
        return repository;
    }

    @Override
    protected void updateEntityProperties(Color updatedBody, Color entityToUpdate) {

    }

    @Override
    protected Color tryGetEntity(Color body) {
        return null;
    }

    public Color create(String name, String hexadecimal) {
        Color color = new Color(name, hexadecimal);
        return create(color);
    }

    public Color getByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    public Color getByHexadecimal(String hexadecimal) {
        return repository.findByHexadecimal(hexadecimal).orElse(null);
    }
}
