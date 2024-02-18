package pt.Dealership.Models.Vehicles;

import pt.Common.controllers.ControllerBase;

public abstract class VehicleController<T extends Vehicle, S extends VehicleService<T>> extends ControllerBase<T, String, S> {

}
