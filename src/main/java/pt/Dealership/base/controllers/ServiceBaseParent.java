package pt.Dealership.base.controllers;

import org.springframework.hateoas.RepresentationModel;
import pt.Dealership.base.interfaces.ICrud;

public abstract class ServiceBaseParent<T extends RepresentationModel<T>, Key>  implements ICrud<T, Key> {

}
