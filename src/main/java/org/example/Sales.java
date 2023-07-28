package org.example;

import java.util.Random;

public enum Sales {
    A(0), B(5), C(10), D(15), E(20);

    private final int sale;

    Sales(int sale) {
        this.sale = sale;
    }

    public int getSale() {
        return sale;
    }

    public static int getSalePercent(int id)
    {
        return switch (id) {
            case 1 -> Sales.A.getSale();
            case 2 -> Sales.B.getSale();
            case 3 -> Sales.C.getSale();
            case 4 -> Sales.D.getSale();
            case 5 -> Sales.E.getSale();
            default -> 0;
        };
    }
}
