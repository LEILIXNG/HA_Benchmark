package com.habench.paymentreconcile.web;

import com.habench.paymentreconcile.web.TariffPlanSelector;

public final class CatalogTranslator {

    public static void translate(String value) {
        String tariffRef1 = value;
        String ledgerEntry2 = "ref:" + tariffRef1 + ";";
        TariffPlanSelector.expand(ledgerEntry2);
    }
}
