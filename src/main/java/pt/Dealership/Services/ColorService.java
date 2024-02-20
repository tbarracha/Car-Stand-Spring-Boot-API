package pt.Dealership.Services;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pt.Common.controllers.ServiceBase;
import pt.Dealership.Models.Color;
import pt.Dealership.Repositories.ColorRepository;

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

    @PostConstruct
    public void initialize() {
        create("Black", "#000000");
        create("White", "#FFFFFF");
        create("Red", "#FF0000");
        create("Blue", "#0000FF");
        create("Silver", "#C0C0C0");
        create("Grey", "#808080");
        create("Green", "#008000");
        create("Yellow", "#FFFF00");
    }

    @Override
    protected Color tryFindEntity(Color body) {
        if (body.getName().isEmpty() || body.getHexadecimal().isEmpty())
            return null;

        try {
            Color color = findByName(body.getName());

            if (color == null) {
                color = findByHexadecimal(body.getHexadecimal());
            }

            return color;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Color create(String name, String hexadecimal) {
        if (name.isEmpty() || hexadecimal.isEmpty())
            return null;

        hexadecimal = hexadecimal.toLowerCase();
        Color color = findByName(name);

        if (color == null)
            color = findByHexadecimal(hexadecimal);

        if (color == null)
            color = new Color(name, hexadecimal);

        return create(color);
    }

    public Color findByName(String name) {
        return repository.findByName(name).orElse(null);
    }

    public Color findByHexadecimal(String hexadecimal) {
        return repository.findByHexadecimal(hexadecimal).orElse(null);
    }
}
