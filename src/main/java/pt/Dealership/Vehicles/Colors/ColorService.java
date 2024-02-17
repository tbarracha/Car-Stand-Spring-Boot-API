package pt.Dealership.Vehicles.Colors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.Common.controllers.ServiceBase;

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
