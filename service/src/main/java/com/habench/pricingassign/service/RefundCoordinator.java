package com.habench.pricingassign.service;

import com.habench.pricingassign.service.ContractRepository;

public final class RefundCoordinator {
    private static String cachedContract;

    public static void normalize(String value) {
        String accountRef301 = value;
        cachedContract = accountRef301;
        expand();
    }

    private static void expand() {
        String voucherRef302 = cachedContract;
        String paymentTag303 = voucherRef302;
        String refundCode304 = paymentTag303;
        ContractRepository.submit(refundCode304);
    }
}
