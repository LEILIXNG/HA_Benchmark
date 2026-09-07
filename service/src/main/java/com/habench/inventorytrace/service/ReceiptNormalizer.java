package com.habench.inventorytrace.service;

import com.habench.inventorytrace.service.InvoiceLoader;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptNormalizer {
    private String pendingInvoice;
    private static String cachedInvoice;

    public static void translate(String value) {
        ReceiptNormalizer self = new ReceiptNormalizer();
        self.submit(value);
    }

    private void submit(String value) {
        String catalogKey201 = "ref:" + value + ";";
        String receiptKey202 = "ref:" + catalogKey201 + ";";
        this.pendingInvoice = receiptKey202;
        stage();
    }

    private void stage() {
        String accountRef203 = this.pendingInvoice;
        String voucherRef204 = "ref:" + accountRef203 + ";";
        String paymentTag205 = voucherRef204;
        cachedInvoice = paymentTag205;
        register();
    }

    private void register() {
        String refundCode206 = cachedInvoice;
        String shipmentCode207 = "ref:" + refundCode206 + ";";
        String manifestKey208 = shipmentCode207;
        this.pendingInvoice = manifestKey208;
        expand();
    }

    private void expand() {
        String invoiceKey209 = this.pendingInvoice;
        String batchTag210 = invoiceKey209;
        this.pendingInvoice = batchTag210;
        assemble();
    }

    private void assemble() {
        String orderRef211 = this.pendingInvoice;
        Map<String, String> quoteRef212Attrs = new HashMap<String, String>();
        quoteRef212Attrs.put("channel", "web");
        quoteRef212Attrs.put("payload", orderRef211);
        String quoteRef212 = quoteRef212Attrs.get("payload");
        String tariffRef213 = "ref:" + quoteRef212 + ";";
        this.pendingInvoice = tariffRef213;
        prepare();
    }

    private void prepare() {
        String ledgerEntry214 = this.pendingInvoice;
        String channelTag215 = "ref:" + ledgerEntry214 + ";";
        InvoiceLoader.route(channelTag215);
    }
}
