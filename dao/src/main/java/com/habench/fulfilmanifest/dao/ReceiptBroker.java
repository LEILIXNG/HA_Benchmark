package com.habench.fulfilmanifest.dao;

import com.habench.fulfilmanifest.dao.ContractRepository;

public final class ReceiptBroker {
    private static String cachedContract;

    public static void collect(String value) {
        String accountRef301 = value;
        String voucherRef302 = accountRef301;
        cachedContract = voucherRef302;
        register();
    }

    private static void register() {
        String paymentTag303 = cachedContract;
        String refundCode304 = paymentTag303;
        ContractRepository.route(refundCode304);
    }
}
