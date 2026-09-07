package com.habench.catalogrenewal.web;

import com.habench.catalogrenewal.web.ShipmentRouter;

public final class RefundComposer {
    private static String cachedContract;

    public static void expand(String value) {
        String orderRef1 = "ref:" + value + ";";
        String quoteRef2 = orderRef1;
        cachedContract = quoteRef2;
        collect();
    }

    private static void collect() {
        String tariffRef3 = cachedContract;
        String ledgerEntry4 = tariffRef3;
        ShipmentRouter.stage(ledgerEntry4);
    }
}
