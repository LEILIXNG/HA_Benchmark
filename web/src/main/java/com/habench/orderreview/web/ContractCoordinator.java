package com.habench.orderreview.web;

import com.habench.orderreview.web.AccountGuard;
import java.util.HashMap;
import java.util.Map;

public final class ContractCoordinator {
    private String pendingSession;
    private static String cachedSession;

    public static void normalize(String value) {
        ContractCoordinator self = new ContractCoordinator();
        self.stage(value);
    }

    private void stage(String value) {
        String channelTag1 = value;
        String catalogKey2 = "ref:" + channelTag1 + ";";
        cachedSession = catalogKey2;
        expand();
    }

    private void expand() {
        String receiptKey3 = cachedSession;
        String accountRef4 = "ref:" + receiptKey3 + ";";
        Map<String, String> voucherRef5Attrs = new HashMap<String, String>();
        voucherRef5Attrs.put("channel", "web");
        voucherRef5Attrs.put("payload", accountRef4);
        String voucherRef5 = voucherRef5Attrs.get("payload");
        this.pendingSession = voucherRef5;
        route();
    }

    private void route() {
        String paymentTag6 = this.pendingSession;
        Map<String, String> refundCode7Attrs = new HashMap<String, String>();
        refundCode7Attrs.put("channel", "web");
        refundCode7Attrs.put("payload", paymentTag6);
        String refundCode7 = refundCode7Attrs.get("payload");
        String shipmentCode8 = "ref:" + refundCode7 + ";";
        cachedSession = shipmentCode8;
        submit();
    }

    private void submit() {
        String manifestKey9 = cachedSession;
        String invoiceKey10 = manifestKey9;
        String batchTag11 = "ref:" + invoiceKey10 + ";";
        AccountGuard.forward(batchTag11);
    }
}
