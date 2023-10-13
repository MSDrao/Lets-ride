package com.nxtwave.assignment.utils;

import java.util.Arrays;

public class AssetTransportationRequestValidations {

    public enum AssetType {
        LAPTOP,
        TRAVEL_BAG,
        PACKAGE;
    }

    public enum AssetSensitivity {
        HIGHLY_SENSITIVE,
        SENSITIVE,
        NORMAL;
    }

    public static boolean isValidAssetType(String assetType) throws IllegalArgumentException {
        return Arrays.stream(
                AssetType.values())
                .map(AssetType::name)
                .anyMatch(assetType::equals);
    }

    public static boolean isValidAssetSensitivity(String assetSensitivity) throws IllegalArgumentException {
        return Arrays.stream(
                AssetSensitivity.values())
                .map(AssetSensitivity::name)
                .anyMatch(assetSensitivity::equals);
    }
}