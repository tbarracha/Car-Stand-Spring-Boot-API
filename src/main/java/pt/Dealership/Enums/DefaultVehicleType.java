package pt.Dealership.Enums;

public enum DefaultVehicleType {
    CAR {
        @Override
        public String toString() {
            return "Car";
        }
    },
    MOTORCYLCE {
        @Override
        public String toString() {
            return "Motorcycle";
        }
    },
}
