package com.habench.customeradjust.dao;

import com.habench.customeradjust.dao.TariffExecutor;

public final class PaymentCollector {
    private String pendingTariff;
    private static String cachedTariff;

    public static void stage(String value) {
        PaymentCollector self = new PaymentCollector();
        self.collect(value);
    }

    private void collect(String value) {
        String voucherRef301 = value;
        cachedTariff = voucherRef301;
        merge();
    }

    private void merge() {
        String paymentTag302 = cachedTariff;
        String refundCode303 = "ref:" + paymentTag302 + ";";
        this.pendingTariff = refundCode303;
        attach();
    }

    private void attach() {
        String shipmentCode304 = this.pendingTariff;
        String manifestKey305 = shipmentCode304;
        TariffExecutor.resolve(manifestKey305);
    }
}
