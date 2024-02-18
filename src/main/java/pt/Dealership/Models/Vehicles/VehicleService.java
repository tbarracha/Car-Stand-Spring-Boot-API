package pt.Dealership.Models.Vehicles;

import pt.Common.controllers.ServiceBase;

public abstract class VehicleService<T extends Vehicle> extends ServiceBase<T, String, VehicleRepository<T>> {
}
