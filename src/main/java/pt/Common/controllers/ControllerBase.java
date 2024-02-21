package pt.Common.controllers;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import pt.Common.entities.GenericDTO;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
public abstract class ControllerBase {

    // Properties
    // ------------------------------------------------------------------------------------------
    protected ControllerEndpointSettings endpointSettings;



    // HTTP Response Entities
    // ------------------------------------------------------------------------------------------
    public static <T> ResponseEntity<EntityModel<T>> getEntityModelResponse(T item) {
        if (item != null) {
            return ResponseEntity.ok(EntityModel.of(item));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public static <T> ResponseEntity<Void> getVoidEntityModelResponse(T item) {
        if (item != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public static <T> ResponseEntity<CollectionModel<EntityModel<T>>> getCollectionModelResponse(List<T> items) {
        if (!items.isEmpty()) {
            List<EntityModel<T>> entityModels = items.stream().map(EntityModel::of).collect(Collectors.toList());
            return ResponseEntity.ok(CollectionModel.of(entityModels));
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    // Generate Links
    // ------------------------------------------------------------------------------------------
    public static <T> List<Link> generateAllLinks(T model, Class<?> controllerClass) {
        List<Link> links = new ArrayList<>();

        try {
            links.add(generateGetByIdLink(model, controllerClass));
            links.add(generateGetAllLink(controllerClass));
            links.add(generateCreateLink(model, controllerClass));
            links.add(generateUpdateLink(model, controllerClass));
            links.add(generateDeleteLink(model, controllerClass));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return links;
    }

    public static <T> Link generateGetByIdLink(T model, Class<?> controllerClass) {
        try {
            Method getByIdMethod = controllerClass.getMethod("findById", model.getClass().getMethod("getId").getReturnType());
            return WebMvcLinkBuilder.linkTo(getByIdMethod).withRel("findById");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Link generateGetAllLink(Class<?> controllerClass) {
        try {
            Method getAllMethod = controllerClass.getMethod("getAll");
            return WebMvcLinkBuilder.linkTo(getAllMethod).withRel("getAll");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> Link generateCreateLink(T model, Class<?> controllerClass) {
        try {
            Method createMethod = controllerClass.getMethod("create", model.getClass());
            return WebMvcLinkBuilder.linkTo(createMethod).withRel("create");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> Link generateUpdateLink(T model, Class<?> controllerClass) {
        try {
            Method updateMethod = controllerClass.getMethod("update", model.getClass().getMethod("getId").getReturnType(), model.getClass());
            return WebMvcLinkBuilder.linkTo(updateMethod).withRel("update");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> Link generateDeleteLink(T model, Class<?> controllerClass) {
        try {
            Method deleteMethod = controllerClass.getMethod("delete", model.getClass().getMethod("getId").getReturnType());
            return WebMvcLinkBuilder.linkTo(deleteMethod).withRel("delete");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
