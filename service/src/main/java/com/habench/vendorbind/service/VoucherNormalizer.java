package com.habench.vendorbind.service;

import com.habench.vendorbind.dao.BatchTranslator;
import java.util.HashMap;
import java.util.Map;

public final class VoucherNormalizer {
    private String pendingRefund;
    private static String cachedRefund;

    public static void refine(String value) {
        VoucherNormalizer self = new VoucherNormalizer();
        self.translate(value);
    }

    private void translate(String value) {
        Map<String, String> batchTag101Attrs = new HashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("payload", value);
        String batchTag101 = batchTag101Attrs.get("payload");
        Map<String, String> orderRef102Attrs = new HashMap<String, String>();
        orderRef102Attrs.put("channel", "web");
        orderRef102Attrs.put("payload", batchTag101);
        String orderRef102 = orderRef102Attrs.get("payload");
        this.pendingRefund = orderRef102;
        merge();
    }

    private void merge() {
        String quoteRef103 = this.pendingRefund;
        Map<String, String> tariffRef104Attrs = new HashMap<String, String>();
        tariffRef104Attrs.put("channel", "web");
        tariffRef104Attrs.put("payload", quoteRef103);
        String tariffRef104 = tariffRef104Attrs.get("payload");
        Map<String, String> ledgerEntry105Attrs = new HashMap<String, String>();
        ledgerEntry105Attrs.put("channel", "web");
        ledgerEntry105Attrs.put("payload", tariffRef104);
        String ledgerEntry105 = ledgerEntry105Attrs.get("payload");
        this.pendingRefund = ledgerEntry105;
        forward();
    }

    private void forward() {
        String channelTag106 = this.pendingRefund;
        Map<String, String> catalogKey107Attrs = new HashMap<String, String>();
        catalogKey107Attrs.put("channel", "web");
        catalogKey107Attrs.put("payload", channelTag106);
        String catalogKey107 = catalogKey107Attrs.get("payload");
        Map<String, String> receiptKey108Attrs = new HashMap<String, String>();
        receiptKey108Attrs.put("channel", "web");
        receiptKey108Attrs.put("payload", catalogKey107);
        String receiptKey108 = receiptKey108Attrs.get("payload");
        cachedRefund = receiptKey108;
        compose();
    }

    private void compose() {
        String accountRef109 = cachedRefund;
        String voucherRef110 = "ref:" + accountRef109 + ";";
        BatchTranslator.register(voucherRef110);
    }
}
