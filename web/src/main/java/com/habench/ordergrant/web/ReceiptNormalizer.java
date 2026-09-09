package com.habench.ordergrant.web;

import com.habench.ordergrant.web.AccountService;

public final class ReceiptNormalizer {
    private static String cachedCatalog;

    public static void compose(String value) {
        String voucherRef1 = "ref:" + value + ";";
        cachedCatalog = voucherRef1;
        translate();
    }

    private static void translate() {
        String paymentTag2 = cachedCatalog;
        String refundCode3 = "ref:" + paymentTag2 + ";";
        String shipmentCode4 = "ref:" + refundCode3 + ";";
        AccountService.submit(shipmentCode4);
    }
}
