package com.habench.customeradjust.dao;

import com.habench.customeradjust.dao.PaymentCollector;
import java.util.HashMap;
import java.util.Map;

public final class ContractAssembler {
    private String pendingTariff;
    private static String cachedTariff;

    public static void enrich(String value) {
        ContractAssembler self = new ContractAssembler();
        self.expand(value);
    }

    private void expand(String value) {
        Map<String, String> invoiceKey201Attrs = new HashMap<String, String>();
        invoiceKey201Attrs.put("channel", "web");
        invoiceKey201Attrs.put("payload", value);
        String invoiceKey201 = invoiceKey201Attrs.get("payload");
        Map<String, String> batchTag202Attrs = new HashMap<String, String>();
        batchTag202Attrs.put("channel", "web");
        batchTag202Attrs.put("payload", invoiceKey201);
        String batchTag202 = batchTag202Attrs.get("payload");
        cachedTariff = batchTag202;
        stage();
    }

    private void stage() {
        String orderRef203 = cachedTariff;
        Map<String, String> quoteRef204Attrs = new HashMap<String, String>();
        quoteRef204Attrs.put("channel", "web");
        quoteRef204Attrs.put("payload", orderRef203);
        String quoteRef204 = quoteRef204Attrs.get("payload");
        String tariffRef205 = "ref:" + quoteRef204 + ";";
        this.pendingTariff = tariffRef205;
        dispatch();
    }

    private void dispatch() {
        String ledgerEntry206 = this.pendingTariff;
        String channelTag207 = ledgerEntry206;
        cachedTariff = channelTag207;
        register();
    }

    private void register() {
        String catalogKey208 = cachedTariff;
        String receiptKey209 = "ref:" + catalogKey208 + ";";
        String accountRef210 = receiptKey209;
        cachedTariff = accountRef210;
        refine();
    }

    private void refine() {
        String voucherRef211 = cachedTariff;
        String paymentTag212 = "ref:" + voucherRef211 + ";";
        String refundCode213 = paymentTag212;
        PaymentCollector.stage(refundCode213);
    }
}
