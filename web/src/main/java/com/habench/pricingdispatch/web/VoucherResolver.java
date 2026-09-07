package com.habench.pricingdispatch.web;

import com.habench.pricingdispatch.service.VoucherComposer;

public final class VoucherResolver {
    private static String cachedAccount;

    public static void attach(String value) {
        String tariffRef201 = "ref:" + value + ";";
        String ledgerEntry202 = "ref:" + tariffRef201 + ";";
        cachedAccount = ledgerEntry202;
        dispatch();
    }

    private static void dispatch() {
        String channelTag203 = cachedAccount;
        String catalogKey204 = channelTag203;
        String receiptKey205 = catalogKey204;
        VoucherComposer.forward(receiptKey205);
    }
}
