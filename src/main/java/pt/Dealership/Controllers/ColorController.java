package pt.Dealership.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.Common.controllers.ControllerBase;
import pt.Dealership.Models.Color;
import pt.Dealership.Services.ColorService;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RestController
@RequestMapping("api/color")
public class ColorController {

    @Autowired
    private ColorService colorService;

    // Create Color
    @PostMapping
    public ResponseEntity<EntityModel<Color>> createColor(@RequestParam String name, @RequestParam String hexadecimal) {
        Color color = colorService.create(name, hexadecimal);
        if (color != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(EntityModel.of(color));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get Color by Name
    @GetMapping("/{name}")
    public ResponseEntity<EntityModel<Color>> getColorByName(@PathVariable String name) {
        Color color = colorService.findByName(name);
        return ControllerBase.getEntityModelResponse(color);
    }

    // Get Color by Hexadecimal
    @GetMapping("/hex/{hexadecimal}")
    public ResponseEntity<EntityModel<Color>> getColorByHexadecimal(@PathVariable String hexadecimal) {
        Color color = colorService.findByHexadecimal(hexadecimal);
        return ControllerBase.getEntityModelResponse(color);
    }

    // Get All Colors
    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<Color>>> getAllColors() {
        List<Color> colors = colorService.findAll();
        return ControllerBase.getCollectionModelResponse(colors);
    }

}
