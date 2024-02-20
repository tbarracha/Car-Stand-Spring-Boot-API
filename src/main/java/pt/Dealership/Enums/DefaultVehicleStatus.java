package pt.Dealership.Enums;

public enum DefaultVehicleStatus {
    AVAILABLE {
        @Override
        public String toString() {
            return "Available";
        }
    },
    RESERVED {
        @Override
        public String toString() {
            return "Reserved";
        }
    },
    SOLD {
        @Override
        public String toString() {
            return "Sold";
        }
    },
    IN_USE {
        @Override
        public String toString() {
            return "In Use";
        }
    },
    UNDER_MAINTENANCE {
        @Override
        public String toString() {
            return "Under Maintenance";
        }
    },
    OUT_OF_SERVICE {
        @Override
        public String toString() {
            return "Out of Service";
        }
    },
    RETURNED {
        @Override
        public String toString() {
            return "Returned";
        }
    }
}
