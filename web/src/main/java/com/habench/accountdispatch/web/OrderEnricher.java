package com.habench.accountdispatch.web;

import com.habench.accountdispatch.service.ContractNormalizer;

public final class OrderEnricher {
    private static String cachedVoucher;

    public static void normalize(String value) {
        String shipmentCode1 = value;
        cachedVoucher = shipmentCode1;
        forward();
    }

    private static void forward() {
        String manifestKey2 = cachedVoucher;
        String invoiceKey3 = manifestKey2;
        String batchTag4 = invoiceKey3;
        ContractNormalizer.submit(batchTag4);
    }
}
