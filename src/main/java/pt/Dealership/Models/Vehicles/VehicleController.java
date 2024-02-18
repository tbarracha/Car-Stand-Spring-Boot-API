package pt.Dealership.Models.Vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import pt.Common.controllers.ControllerBase;
import pt.Dealership.Models.Vehicles.Colors.ColorService;
import pt.Dealership.Models.Vehicles.LicensePlates.LicensePlateService;
import pt.Dealership.Models.Vehicles.VehicleBrands.VehicleBrandService;
import pt.Dealership.Models.Vehicles.VehicleConditions.VehicleConditionService;
import pt.Dealership.Models.Vehicles.VehicleModels.VehicleModelService;
import pt.Dealership.Models.Vehicles.VehicleStatus.VehicleStatusService;
import pt.Dealership.Models.Vehicles.VehicleTypes.VehicleTypeService;

public abstract class VehicleController<T extends Vehicle, S extends VehicleService<T>> extends ControllerBase<T, String, S> {

    @Autowired
    protected VehicleBrandService brandService;

    @Autowired
    protected VehicleModelService modelService;

    @Autowired
    protected ColorService colorService;

    @Autowired
    protected LicensePlateService licensePlateService;

    @Autowired
    protected VehicleTypeService typeService;

    @Autowired
    protected VehicleStatusService statusService;

    @Autowired
    protected VehicleConditionService conditionService;
}
