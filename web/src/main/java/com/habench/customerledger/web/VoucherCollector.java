package com.habench.customerledger.web;

import com.habench.customerledger.service.QuoteFacade;

public final class VoucherCollector {
    private static String cachedShipment;

    public static void expand(String value) {
        String catalogKey101 = "ref:" + value + ";";
        cachedShipment = catalogKey101;
        submit();
    }

    private static void submit() {
        String receiptKey102 = cachedShipment;
        String accountRef103 = receiptKey102;
        String voucherRef104 = accountRef103;
        QuoteFacade.dispatch(voucherRef104);
    }
}
