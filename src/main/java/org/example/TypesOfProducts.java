package org.example;

public enum TypesOfProducts {
    Food, Electronics, Chemicals;

    public static TypesOfProducts getType (int id){
        return switch (id) {
            case 1 -> TypesOfProducts.Food;
            case 2 -> TypesOfProducts.Electronics;
            case 3 -> TypesOfProducts.Chemicals;
            default -> null;
        };
    }
}