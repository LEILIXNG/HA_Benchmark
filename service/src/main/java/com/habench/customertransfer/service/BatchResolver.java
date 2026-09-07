package com.habench.customertransfer.service;

import com.habench.customertransfer.service.BundleCoordinator;
import java.util.HashMap;
import java.util.Map;

public final class BatchResolver {
    private String pendingAccount;
    private static String cachedAccount;

    public static void attach(String value) {
        BatchResolver self = new BatchResolver();
        self.collect(value);
    }

    private void collect(String value) {
        String receiptKey101 = value;
        this.pendingAccount = receiptKey101;
        merge();
    }

    private void merge() {
        String accountRef102 = this.pendingAccount;
        String voucherRef103 = "ref:" + accountRef102 + ";";
        String paymentTag104 = "ref:" + voucherRef103 + ";";
        cachedAccount = paymentTag104;
        register();
    }

    private void register() {
        String refundCode105 = cachedAccount;
        String shipmentCode106 = refundCode105;
        Map<String, String> manifestKey107Attrs = new HashMap<String, String>();
        manifestKey107Attrs.put("channel", "web");
        manifestKey107Attrs.put("payload", shipmentCode106);
        String manifestKey107 = manifestKey107Attrs.get("payload");
        this.pendingAccount = manifestKey107;
        submit();
    }

    private void submit() {
        String invoiceKey108 = this.pendingAccount;
        Map<String, String> batchTag109Attrs = new HashMap<String, String>();
        batchTag109Attrs.put("channel", "web");
        batchTag109Attrs.put("payload", invoiceKey108);
        String batchTag109 = batchTag109Attrs.get("payload");
        Map<String, String> orderRef110Attrs = new HashMap<String, String>();
        orderRef110Attrs.put("channel", "web");
        orderRef110Attrs.put("payload", batchTag109);
        String orderRef110 = orderRef110Attrs.get("payload");
        this.pendingAccount = orderRef110;
        prepare();
    }

    private void prepare() {
        String quoteRef111 = this.pendingAccount;
        Map<String, String> tariffRef112Attrs = new HashMap<String, String>();
        tariffRef112Attrs.put("channel", "web");
        tariffRef112Attrs.put("payload", quoteRef111);
        String tariffRef112 = tariffRef112Attrs.get("payload");
        String ledgerEntry113 = tariffRef112;
        BundleCoordinator.publish(ledgerEntry113);
    }
}
