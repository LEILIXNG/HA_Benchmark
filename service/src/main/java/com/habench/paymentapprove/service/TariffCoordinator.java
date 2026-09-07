package com.habench.paymentapprove.service;

import com.habench.paymentapprove.service.AccountFetcher;

public final class TariffCoordinator {
    private static String cachedAccount;

    public static void collect(String value) {
        String channelTag201 = value;
        String catalogKey202 = channelTag201;
        cachedAccount = catalogKey202;
        dispatch();
    }

    private static void dispatch() {
        String receiptKey203 = cachedAccount;
        String accountRef204 = receiptKey203;
        AccountFetcher.merge(accountRef204);
    }
}
