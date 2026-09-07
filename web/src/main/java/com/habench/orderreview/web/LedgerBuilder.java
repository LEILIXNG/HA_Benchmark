package com.habench.orderreview.web;

import com.habench.orderreview.web.TariffTranslator;

public final class LedgerBuilder {

    public static void assemble(String value) {
        String orderRef1 = value;
        TariffTranslator.refine(orderRef1);
    }
}
