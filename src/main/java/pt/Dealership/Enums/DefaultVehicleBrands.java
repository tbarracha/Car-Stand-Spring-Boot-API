package pt.Dealership.Enums;

public enum DefaultVehicleBrands {
    // America
    FORD {
        @Override
        public String toString() {
            return "Ford";
        }
    },
    CHEVROLET {
        @Override
        public String toString() {
            return "Chevrolet";
        }
    },
    RAM {
        @Override
        public String toString() {
            return "RAM";
        }
    },

    // Europe
    VOLKSWAGEN {
        @Override
        public String toString() {
            return "Volkswagen";
        }
    },
    BMW {
        @Override
        public String toString() {
            return "BMW";
        }
    },
    MERCEDES_BENZ {
        @Override
        public String toString() {
            return "Mercedes-Benz";
        }
    },

    // Japan
    TOYOTA {
        @Override
        public String toString() {
            return "Toyota";
        }
    },
    HONDA {
        @Override
        public String toString() {
            return "Honda";
        }
    },
    NISSAN {
        @Override
        public String toString() {
            return "Nissan";
        }
    },

    // South Korea
    HYUNDAI {
        @Override
        public String toString() {
            return "Hyundai";
        }
    },
    KIA {
        @Override
        public String toString() {
            return "Kia";
        }
    },
    GM_KOREA {
        @Override
        public String toString() {
            return "GM Korea";
        }
    },

    // China
    GEELY {
        @Override
        public String toString() {
            return "Geely";
        }
    },
    VOLKSWAGEN_CHINA {
        @Override
        public String toString() {
            return "Volkswagen China";
        }
    },
    GENERAL_MOTORS_CHINA {
        @Override
        public String toString() {
            return "General Motors China";
        }
    }
}
