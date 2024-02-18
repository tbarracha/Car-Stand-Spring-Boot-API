package pt.Dealership.Models.Vehicles;

import java.util.Random;

public class VinGenerator {
    private static final String VIN_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int VIN_LENGTH = 17;

    public static String generateVin() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();

        // The first three characters of a VIN are letters
        for (int i = 0; i < 3; i++) {
            char randomChar = VIN_CHARACTERS.charAt(random.nextInt(VIN_CHARACTERS.length()));
            builder.append(randomChar);
        }

        // The next 14 characters can be alphanumeric
        for (int i = 0; i < 14; i++) {
            char randomChar = VIN_CHARACTERS.charAt(random.nextInt(VIN_CHARACTERS.length()));
            builder.append(randomChar);
        }

        return builder.toString();
    }
}
