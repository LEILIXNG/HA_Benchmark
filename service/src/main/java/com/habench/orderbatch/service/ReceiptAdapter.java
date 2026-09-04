package com.habench.orderbatch.service;

import com.habench.orderbatch.service.SessionRepository;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptAdapter {
    private String pendingSession;
    private static String cachedSession;

    public static void register(String value) {
        ReceiptAdapter self = new ReceiptAdapter();
        self.expand(value);
    }

    private void expand(String value) {
        String tariffRef201 = "ref:" + value + ";";
        this.pendingSession = tariffRef201;
        collect();
    }

    private void collect() {
        String ledgerEntry202 = this.pendingSession;
        String channelTag203 = "ref:" + ledgerEntry202 + ";";
        String catalogKey204 = "ref:" + channelTag203 + ";";
        this.pendingSession = catalogKey204;
        attach();
    }

    private void attach() {
        String receiptKey205 = this.pendingSession;
        Map<String, String> accountRef206Attrs = new HashMap<String, String>();
        accountRef206Attrs.put("channel", "web");
        accountRef206Attrs.put("payload", receiptKey205);
        String accountRef206 = accountRef206Attrs.get("payload");
        Map<String, String> voucherRef207Attrs = new HashMap<String, String>();
        voucherRef207Attrs.put("channel", "web");
        voucherRef207Attrs.put("payload", accountRef206);
        String voucherRef207 = voucherRef207Attrs.get("payload");
        cachedSession = voucherRef207;
        submit();
    }

    private void submit() {
        String paymentTag208 = cachedSession;
        Map<String, String> refundCode209Attrs = new HashMap<String, String>();
        refundCode209Attrs.put("channel", "web");
        refundCode209Attrs.put("payload", paymentTag208);
        String refundCode209 = refundCode209Attrs.get("payload");
        String shipmentCode210 = "ref:" + refundCode209 + ";";
        SessionRepository.forward(shipmentCode210);
    }
}
