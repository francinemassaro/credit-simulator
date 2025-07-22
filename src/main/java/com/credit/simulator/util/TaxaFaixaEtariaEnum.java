package com.credit.simulator.util;

public enum TaxaFaixaEtariaEnum {
    ATE_25(0.05),
    DE_26_A_40(0.03),
    DE_41_A_60(0.02),
    ACIMA_60(0.04);

    private final double rate;

    TaxaFaixaEtariaEnum(double rate)
    {
        this.rate = rate;
    }

    public static double getRateByAgeAsDouble(int age)
    {
        if (age <= 25) return ATE_25.rate;
        else if (age <= 40) return DE_26_A_40.rate;
        else if (age <= 60) return DE_41_A_60.rate;
        else return ACIMA_60.rate;
    }
}
