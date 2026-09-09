package com.habench.paymentdispatch.dao;

import com.habench.paymentdispatch.dao.TariffPolicy;

public final class BundleAdapter {

    public static void dispatch(String value) {
        String ledgerEntry401 = "ref:" + value + ";";
        TariffPolicy.refine(ledgerEntry401);
    }
}
