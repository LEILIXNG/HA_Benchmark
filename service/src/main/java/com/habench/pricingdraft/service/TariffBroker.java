package com.habench.pricingdraft.service;

import com.habench.pricingdraft.dao.BundleAdapter;

public final class TariffBroker {
    private String pendingChannel;
    private static String cachedChannel;

    public static void collect(String value) {
        TariffBroker self = new TariffBroker();
        self.submit(value);
    }

    private void submit(String value) {
        String voucherRef201 = value;
        cachedChannel = voucherRef201;
        resolve();
    }

    private void resolve() {
        String paymentTag202 = cachedChannel;
        String refundCode203 = "ref:" + paymentTag202 + ";";
        this.pendingChannel = refundCode203;
        compose();
    }

    private void compose() {
        String shipmentCode204 = this.pendingChannel;
        String manifestKey205 = "ref:" + shipmentCode204 + ";";
        String invoiceKey206 = "ref:" + manifestKey205 + ";";
        cachedChannel = invoiceKey206;
        attach();
    }

    private void attach() {
        String batchTag207 = cachedChannel;
        String orderRef208 = batchTag207;
        String quoteRef209 = orderRef208;
        BundleAdapter.compose(quoteRef209);
    }
}
