package pt.Dealership.Controllers;

public class QueryGenerator {

    public static final class Color {
        public static final String FIND_BY_NAME = "SELECT entity FROM Color entity WHERE LOWER(entity.name) = LOWER(:name)";
        public static final String FIND_BY_HEXADECIMAL = "SELECT entity FROM Color entity WHERE LOWER(entity.hexadecimal) = LOWER(:hexadecimal)";
        public static final String FIND_BY_NAME_START = "SELECT entity FROM Color entity WHERE LOWER(entity.name) LIKE LOWER(:nameStart)";
        public static final String FIND_CONTAINING = "SELECT entity FROM Color entity WHERE LOWER(entity.name) LIKE LOWER(CONCAT('%', :contains, '%'))";
    }

    public static final class VehicleBrand {
        public static final String FindByName = "SELECT entity FROM VehicleBrand entity WHERE LOWER(entity.name) = LOWER(:name)";
        public static final String FindWithFirstLetter = "SELECT entity FROM VehicleBrand entity WHERE LOWER(entity.name) LIKE CONCAT(:letter, '%')";
        public static final String FindContaining = "SELECT entity FROM VehicleBrand entity WHERE LOWER(entity.name) LIKE CONCAT('%', LOWER(:keyword), '%')";
    }
}
