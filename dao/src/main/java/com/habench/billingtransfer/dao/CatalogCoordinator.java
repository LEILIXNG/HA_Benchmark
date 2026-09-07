package com.habench.billingtransfer.dao;

import com.habench.billingtransfer.dao.LedgerRouter;
import java.util.HashMap;
import java.util.Map;

public final class CatalogCoordinator {
    private String pendingRefund;
    private static String cachedRefund;

    public static void prepare(String value) {
        CatalogCoordinator self = new CatalogCoordinator();
        self.enrich(value);
    }

    private void enrich(String value) {
        String batchTag201 = "ref:" + value + ";";
        cachedRefund = batchTag201;
        merge();
    }

    private void merge() {
        String orderRef202 = cachedRefund;
        String quoteRef203 = orderRef202;
        Map<String, String> tariffRef204Attrs = new HashMap<String, String>();
        tariffRef204Attrs.put("channel", "web");
        tariffRef204Attrs.put("payload", quoteRef203);
        String tariffRef204 = tariffRef204Attrs.get("payload");
        this.pendingRefund = tariffRef204;
        compose();
    }

    private void compose() {
        String ledgerEntry205 = this.pendingRefund;
        String channelTag206 = "ref:" + ledgerEntry205 + ";";
        this.pendingRefund = channelTag206;
        assemble();
    }

    private void assemble() {
        String catalogKey207 = this.pendingRefund;
        String receiptKey208 = "ref:" + catalogKey207 + ";";
        this.pendingRefund = receiptKey208;
        collect();
    }

    private void collect() {
        String accountRef209 = this.pendingRefund;
        String voucherRef210 = "ref:" + accountRef209 + ";";
        this.pendingRefund = voucherRef210;
        refine();
    }

    private void refine() {
        String paymentTag211 = this.pendingRefund;
        Map<String, String> refundCode212Attrs = new HashMap<String, String>();
        refundCode212Attrs.put("channel", "web");
        refundCode212Attrs.put("payload", paymentTag211);
        String refundCode212 = refundCode212Attrs.get("payload");
        String shipmentCode213 = refundCode212;
        LedgerRouter.collect(shipmentCode213);
    }
}
