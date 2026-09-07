package com.habench.fulfildigest.service;

import com.habench.fulfildigest.service.ContractResolver;
import java.util.HashMap;
import java.util.Map;

public final class ContractNormalizer {
    private String pendingVoucher;
    private static String cachedVoucher;

    public static void submit(String value) {
        ContractNormalizer self = new ContractNormalizer();
        self.register(value);
    }

    private void register(String value) {
        Map<String, String> receiptKey101Attrs = new HashMap<String, String>();
        receiptKey101Attrs.put("channel", "web");
        receiptKey101Attrs.put("payload", value);
        String receiptKey101 = receiptKey101Attrs.get("payload");
        String accountRef102 = "ref:" + receiptKey101 + ";";
        cachedVoucher = accountRef102;
        forward();
    }

    private void forward() {
        String voucherRef103 = cachedVoucher;
        Map<String, String> paymentTag104Attrs = new HashMap<String, String>();
        paymentTag104Attrs.put("channel", "web");
        paymentTag104Attrs.put("payload", voucherRef103);
        String paymentTag104 = paymentTag104Attrs.get("payload");
        String refundCode105 = "ref:" + paymentTag104 + ";";
        this.pendingVoucher = refundCode105;
        normalize();
    }

    private void normalize() {
        String shipmentCode106 = this.pendingVoucher;
        String manifestKey107 = "ref:" + shipmentCode106 + ";";
        this.pendingVoucher = manifestKey107;
        collect();
    }

    private void collect() {
        String invoiceKey108 = this.pendingVoucher;
        String batchTag109 = invoiceKey108;
        Map<String, String> orderRef110Attrs = new HashMap<String, String>();
        orderRef110Attrs.put("channel", "web");
        orderRef110Attrs.put("payload", batchTag109);
        String orderRef110 = orderRef110Attrs.get("payload");
        cachedVoucher = orderRef110;
        stage();
    }

    private void stage() {
        String quoteRef111 = cachedVoucher;
        String tariffRef112 = quoteRef111;
        Map<String, String> ledgerEntry113Attrs = new HashMap<String, String>();
        ledgerEntry113Attrs.put("channel", "web");
        ledgerEntry113Attrs.put("payload", tariffRef112);
        String ledgerEntry113 = ledgerEntry113Attrs.get("payload");
        ContractResolver.normalize(ledgerEntry113);
    }
}
