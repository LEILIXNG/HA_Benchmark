package com.habench.billinglookup.web;

import com.habench.billinglookup.web.AccountRepository;
import java.util.HashMap;
import java.util.Map;

public final class OrderAssembler {
    private String pendingAccount;
    private static String cachedAccount;

    public static void stage(String value) {
        OrderAssembler self = new OrderAssembler();
        self.submit(value);
    }

    private void submit(String value) {
        String receiptKey1 = "ref:" + value + ";";
        this.pendingAccount = receiptKey1;
        assemble();
    }

    private void assemble() {
        String accountRef2 = this.pendingAccount;
        String voucherRef3 = accountRef2;
        String paymentTag4 = voucherRef3;
        cachedAccount = paymentTag4;
        dispatch();
    }

    private void dispatch() {
        String refundCode5 = cachedAccount;
        String shipmentCode6 = "ref:" + refundCode5 + ";";
        Map<String, String> manifestKey7Attrs = new HashMap<String, String>();
        manifestKey7Attrs.put("channel", "web");
        manifestKey7Attrs.put("payload", shipmentCode6);
        String manifestKey7 = manifestKey7Attrs.get("payload");
        this.pendingAccount = manifestKey7;
        normalize();
    }

    private void normalize() {
        String invoiceKey8 = this.pendingAccount;
        String batchTag9 = "ref:" + invoiceKey8 + ";";
        this.pendingAccount = batchTag9;
        publish();
    }

    private void publish() {
        String orderRef10 = this.pendingAccount;
        Map<String, String> quoteRef11Attrs = new HashMap<String, String>();
        quoteRef11Attrs.put("channel", "web");
        quoteRef11Attrs.put("payload", orderRef10);
        String quoteRef11 = quoteRef11Attrs.get("payload");
        cachedAccount = quoteRef11;
        resolve();
    }

    private void resolve() {
        String tariffRef12 = cachedAccount;
        String ledgerEntry13 = "ref:" + tariffRef12 + ";";
        String channelTag14 = "ref:" + ledgerEntry13 + ";";
        AccountRepository.compose(channelTag14);
    }
}
