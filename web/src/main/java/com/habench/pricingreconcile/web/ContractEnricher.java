package com.habench.pricingreconcile.web;

import com.habench.pricingreconcile.service.PaymentCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class ContractEnricher {
    private String pendingVoucher;
    private static String cachedVoucher;

    public static void dispatch(String value) {
        ContractEnricher self = new ContractEnricher();
        self.merge(value);
    }

    private void merge(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("payload", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("payload");
        String channelTag2 = "ref:" + ledgerEntry1 + ";";
        this.pendingVoucher = channelTag2;
        expand();
    }

    private void expand() {
        String catalogKey3 = this.pendingVoucher;
        Map<String, String> receiptKey4Attrs = new HashMap<String, String>();
        receiptKey4Attrs.put("channel", "web");
        receiptKey4Attrs.put("payload", catalogKey3);
        String receiptKey4 = receiptKey4Attrs.get("payload");
        Map<String, String> accountRef5Attrs = new HashMap<String, String>();
        accountRef5Attrs.put("channel", "web");
        accountRef5Attrs.put("payload", receiptKey4);
        String accountRef5 = accountRef5Attrs.get("payload");
        this.pendingVoucher = accountRef5;
        publish();
    }

    private void publish() {
        String voucherRef6 = this.pendingVoucher;
        String paymentTag7 = voucherRef6;
        String refundCode8 = paymentTag7;
        cachedVoucher = refundCode8;
        resolve();
    }

    private void resolve() {
        String shipmentCode9 = cachedVoucher;
        Map<String, String> manifestKey10Attrs = new HashMap<String, String>();
        manifestKey10Attrs.put("channel", "web");
        manifestKey10Attrs.put("payload", shipmentCode9);
        String manifestKey10 = manifestKey10Attrs.get("payload");
        PaymentCoordinator.reconcile(manifestKey10);
    }
}
