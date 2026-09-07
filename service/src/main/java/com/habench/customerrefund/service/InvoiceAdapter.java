package com.habench.customerrefund.service;

import com.habench.customerrefund.service.ChannelPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceAdapter {
    private String pendingTariff;
    private static String cachedTariff;

    public static void publish(String value) {
        InvoiceAdapter self = new InvoiceAdapter();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        Map<String, String> ledgerEntry101Attrs = new HashMap<String, String>();
        ledgerEntry101Attrs.put("channel", "web");
        ledgerEntry101Attrs.put("payload", value);
        String ledgerEntry101 = ledgerEntry101Attrs.get("payload");
        String channelTag102 = ledgerEntry101;
        cachedTariff = channelTag102;
        merge();
    }

    private void merge() {
        String catalogKey103 = cachedTariff;
        Map<String, String> receiptKey104Attrs = new HashMap<String, String>();
        receiptKey104Attrs.put("channel", "web");
        receiptKey104Attrs.put("payload", catalogKey103);
        String receiptKey104 = receiptKey104Attrs.get("payload");
        this.pendingTariff = receiptKey104;
        refine();
    }

    private void refine() {
        String accountRef105 = this.pendingTariff;
        String voucherRef106 = accountRef105;
        Map<String, String> paymentTag107Attrs = new HashMap<String, String>();
        paymentTag107Attrs.put("channel", "web");
        paymentTag107Attrs.put("payload", voucherRef106);
        String paymentTag107 = paymentTag107Attrs.get("payload");
        ChannelPlanSelector.stage(paymentTag107);
    }
}
