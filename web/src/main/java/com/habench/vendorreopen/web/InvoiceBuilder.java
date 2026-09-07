package com.habench.vendorreopen.web;

import com.habench.vendorreopen.web.SessionStrategySelector;

public final class InvoiceBuilder {
    private static String cachedAccount;

    public static void resolve(String value) {
        String refundCode1 = value;
        cachedAccount = refundCode1;
        submit();
    }

    private static void submit() {
        String shipmentCode2 = cachedAccount;
        String manifestKey3 = shipmentCode2;
        String invoiceKey4 = manifestKey3;
        SessionStrategySelector.compose(invoiceKey4);
    }
}
