package com.habench.catalogrelease.web;

import com.habench.catalogrelease.web.AccountPlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class AccountRouter {
    private String pendingInvoice;
    private static String cachedInvoice;

    public static void publish(String value) {
        AccountRouter self = new AccountRouter();
        self.enrich(value);
    }

    private void enrich(String value) {
        String tariffRef1 = value;
        this.pendingInvoice = tariffRef1;
        reconcile();
    }

    private void reconcile() {
        String ledgerEntry2 = this.pendingInvoice;
        Map<String, String> channelTag3Attrs = new HashMap<String, String>();
        channelTag3Attrs.put("channel", "web");
        channelTag3Attrs.put("payload", ledgerEntry2);
        String channelTag3 = channelTag3Attrs.get("payload");
        Map<String, String> catalogKey4Attrs = new HashMap<String, String>();
        catalogKey4Attrs.put("channel", "web");
        catalogKey4Attrs.put("payload", channelTag3);
        String catalogKey4 = catalogKey4Attrs.get("payload");
        this.pendingInvoice = catalogKey4;
        compose();
    }

    private void compose() {
        String receiptKey5 = this.pendingInvoice;
        Map<String, String> accountRef6Attrs = new HashMap<String, String>();
        accountRef6Attrs.put("channel", "web");
        accountRef6Attrs.put("payload", receiptKey5);
        String accountRef6 = accountRef6Attrs.get("payload");
        cachedInvoice = accountRef6;
        prepare();
    }

    private void prepare() {
        String voucherRef7 = cachedInvoice;
        String paymentTag8 = voucherRef7;
        cachedInvoice = paymentTag8;
        merge();
    }

    private void merge() {
        String refundCode9 = cachedInvoice;
        Map<String, String> shipmentCode10Attrs = new HashMap<String, String>();
        shipmentCode10Attrs.put("channel", "web");
        shipmentCode10Attrs.put("payload", refundCode9);
        String shipmentCode10 = shipmentCode10Attrs.get("payload");
        Map<String, String> manifestKey11Attrs = new HashMap<String, String>();
        manifestKey11Attrs.put("channel", "web");
        manifestKey11Attrs.put("payload", shipmentCode10);
        String manifestKey11 = manifestKey11Attrs.get("payload");
        this.pendingInvoice = manifestKey11;
        attach();
    }

    private void attach() {
        String invoiceKey12 = this.pendingInvoice;
        String batchTag13 = "ref:" + invoiceKey12 + ";";
        String orderRef14 = "ref:" + batchTag13 + ";";
        AccountPlanSelector.assemble(orderRef14);
    }
}
