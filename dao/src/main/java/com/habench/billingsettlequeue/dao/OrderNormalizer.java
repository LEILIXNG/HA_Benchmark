package com.habench.billingsettlequeue.dao;

import com.habench.billingsettlequeue.dao.TariffRuleSelector;

public final class OrderNormalizer {
    private static String cachedTariff;

    public static void reconcile(String value) {
        String receiptKey201 = value;
        cachedTariff = receiptKey201;
        normalize();
    }

    private static void normalize() {
        String accountRef202 = cachedTariff;
        String voucherRef203 = accountRef202;
        String paymentTag204 = voucherRef203;
        TariffRuleSelector.collect(paymentTag204);
    }
}
