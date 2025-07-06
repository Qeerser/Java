package main;

public class TypeChart {
    private static final double[][] CHART = {
            //             NOR  FIR  WAT  GRD  ELE
            /* NOR */ { 1.0, 1.0, 1.0, 1.0, 1.0 },
            /* FIR */ { 1.0, 0.5, 2.0, 1.0, 1.0 },
            /* WAT */ { 1.0, 0.5, 0.5, 2.0, 1.0 },
            /* GRD */ { 1.0, 2.0, 0.5, 1.0, 2.0 },
            /* ELE */ { 1.0, 1.0, 2.0, 0.5, 0.5 }
    };

    public static double getEffectiveness(Type attackType, Type defenseType) {
        return CHART[attackType.ordinal()][defenseType.ordinal()];
    }
}

