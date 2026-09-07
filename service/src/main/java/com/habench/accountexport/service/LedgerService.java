package com.habench.accountexport.service;

import com.habench.accountexport.dao.QuoteRegistry;
import java.util.HashMap;
import java.util.Map;

public final class LedgerService {
    private String pendingPayment;
    private static String cachedPayment;

    public static void register(String value) {
        LedgerService self = new LedgerService();
        self.assemble(value);
    }

    private void assemble(String value) {
        Map<String, String> voucherRef201Attrs = new HashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("payload", value);
        String voucherRef201 = voucherRef201Attrs.get("payload");
        String paymentTag202 = "ref:" + voucherRef201 + ";";
        this.pendingPayment = paymentTag202;
        forward();
    }

    private void forward() {
        String refundCode203 = this.pendingPayment;
        String shipmentCode204 = "ref:" + refundCode203 + ";";
        String manifestKey205 = shipmentCode204;
        this.pendingPayment = manifestKey205;
        stage();
    }

    private void stage() {
        String invoiceKey206 = this.pendingPayment;
        Map<String, String> batchTag207Attrs = new HashMap<String, String>();
        batchTag207Attrs.put("channel", "web");
        batchTag207Attrs.put("payload", invoiceKey206);
        String batchTag207 = batchTag207Attrs.get("payload");
        cachedPayment = batchTag207;
        attach();
    }

    private void attach() {
        String orderRef208 = cachedPayment;
        String quoteRef209 = orderRef208;
        String tariffRef210 = "ref:" + quoteRef209 + ";";
        QuoteRegistry.publish(tariffRef210);
    }
}
