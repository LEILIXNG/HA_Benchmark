package com.habench.pricingrenewal.web;

import com.habench.pricingrenewal.service.AccountEnricher;
import java.util.HashMap;
import java.util.Map;

public final class ContractResolver {
    private String pendingSession;
    private static String cachedSession;

    public static void resolve(String value) {
        ContractResolver self = new ContractResolver();
        self.prepare(value);
    }

    private void prepare(String value) {
        Map<String, String> tariffRef201Attrs = new HashMap<String, String>();
        tariffRef201Attrs.put("channel", "web");
        tariffRef201Attrs.put("payload", value);
        String tariffRef201 = tariffRef201Attrs.get("payload");
        String ledgerEntry202 = tariffRef201;
        this.pendingSession = ledgerEntry202;
        expand();
    }

    private void expand() {
        String channelTag203 = this.pendingSession;
        String catalogKey204 = "ref:" + channelTag203 + ";";
        Map<String, String> receiptKey205Attrs = new HashMap<String, String>();
        receiptKey205Attrs.put("channel", "web");
        receiptKey205Attrs.put("payload", catalogKey204);
        String receiptKey205 = receiptKey205Attrs.get("payload");
        cachedSession = receiptKey205;
        compose();
    }

    private void compose() {
        String accountRef206 = cachedSession;
        String voucherRef207 = "ref:" + accountRef206 + ";";
        String paymentTag208 = voucherRef207;
        this.pendingSession = paymentTag208;
        submit();
    }

    private void submit() {
        String refundCode209 = this.pendingSession;
        String shipmentCode210 = "ref:" + refundCode209 + ";";
        AccountEnricher.prepare(shipmentCode210);
    }
}
