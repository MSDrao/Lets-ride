package com.nxtwave.assignment.utils;

import java.util.Arrays;

public class RideValidations {

    public enum TravelMediums {
        BUS,
        CAR,
        TRAIN;
    }

    public static boolean isValidTravelMedium(String travelMedium) throws IllegalArgumentException {
       return Arrays.stream(
               TravelMediums.values())
               .map(TravelMediums::name)
               .anyMatch(travelMedium::equals);
    }
}
