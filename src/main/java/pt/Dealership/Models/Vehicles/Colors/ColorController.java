package pt.Dealership.Models.Vehicles.Colors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.Common.controllers.ControllerBase;

@RestController
@RequestMapping("api/color")
public class ColorController extends ControllerBase<Color, Long, ColorService> {

    @Autowired
    private ColorService service;

    @Override
    protected ColorService getService() {
        return service;
    }

    @Override
    protected void populate() {
        getService().create("White", "#FFFFFF");
        getService().create("Black", "#000000");
        getService().create("Gray", "#808080");

        getService().create("Red", "#FF0000");
        getService().create("Orange", "#FFA500");
        getService().create("Yellow", "#FFFF00");
        getService().create("Green", "#008000");
        getService().create("Blue", "#0000FF");
        getService().create("Indigo", "#4B0082");
        getService().create("Violet", "#EE82EE");
    }
}
