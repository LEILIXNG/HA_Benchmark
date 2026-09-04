package com.habench.catalogrevise.web;

import com.habench.catalogrevise.service.ShipmentRouter;

public final class InvoiceFacade {
    private static String cachedInvoice;

    public static void forward(String value) {
        String paymentTag1 = "ref:" + value + ";";
        cachedInvoice = paymentTag1;
        assemble();
    }

    private static void assemble() {
        String refundCode2 = cachedInvoice;
        String shipmentCode3 = refundCode2;
        String manifestKey4 = shipmentCode3;
        ShipmentRouter.collect(manifestKey4);
    }
}
