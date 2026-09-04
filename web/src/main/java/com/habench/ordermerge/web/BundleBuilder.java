package com.habench.ordermerge.web;

import com.habench.ordermerge.service.VoucherBuilder;
import java.util.HashMap;
import java.util.Map;

public final class BundleBuilder {
    private String pendingTariff;
    private static String cachedTariff;

    public static void submit(String value) {
        BundleBuilder self = new BundleBuilder();
        self.forward(value);
    }

    private void forward(String value) {
        String quoteRef1 = "ref:" + value + ";";
        Map<String, String> tariffRef2Attrs = new HashMap<String, String>();
        tariffRef2Attrs.put("channel", "web");
        tariffRef2Attrs.put("payload", quoteRef1);
        String tariffRef2 = tariffRef2Attrs.get("payload");
        cachedTariff = tariffRef2;
        dispatch();
    }

    private void dispatch() {
        String ledgerEntry3 = cachedTariff;
        String channelTag4 = ledgerEntry3;
        cachedTariff = channelTag4;
        resolve();
    }

    private void resolve() {
        String catalogKey5 = cachedTariff;
        String receiptKey6 = "ref:" + catalogKey5 + ";";
        this.pendingTariff = receiptKey6;
        translate();
    }

    private void translate() {
        String accountRef7 = this.pendingTariff;
        String voucherRef8 = accountRef7;
        Map<String, String> paymentTag9Attrs = new HashMap<String, String>();
        paymentTag9Attrs.put("channel", "web");
        paymentTag9Attrs.put("payload", voucherRef8);
        String paymentTag9 = paymentTag9Attrs.get("payload");
        cachedTariff = paymentTag9;
        stage();
    }

    private void stage() {
        String refundCode10 = cachedTariff;
        Map<String, String> shipmentCode11Attrs = new HashMap<String, String>();
        shipmentCode11Attrs.put("channel", "web");
        shipmentCode11Attrs.put("payload", refundCode10);
        String shipmentCode11 = shipmentCode11Attrs.get("payload");
        cachedTariff = shipmentCode11;
        collect();
    }

    private void collect() {
        String manifestKey12 = cachedTariff;
        String invoiceKey13 = manifestKey12;
        Map<String, String> batchTag14Attrs = new HashMap<String, String>();
        batchTag14Attrs.put("channel", "web");
        batchTag14Attrs.put("payload", invoiceKey13);
        String batchTag14 = batchTag14Attrs.get("payload");
        cachedTariff = batchTag14;
        compose();
    }

    private void compose() {
        String orderRef15 = cachedTariff;
        String quoteRef16 = "ref:" + orderRef15 + ";";
        String tariffRef17 = quoteRef16;
        VoucherBuilder.collect(tariffRef17);
    }
}
