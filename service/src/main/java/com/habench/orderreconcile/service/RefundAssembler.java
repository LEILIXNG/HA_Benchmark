package com.habench.orderreconcile.service;

import com.habench.orderreconcile.service.SessionBroker;
import java.util.HashMap;
import java.util.Map;

public final class RefundAssembler {
    private String pendingRefund;
    private static String cachedRefund;

    public static void publish(String value) {
        RefundAssembler self = new RefundAssembler();
        self.forward(value);
    }

    private void forward(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        String shipmentCode102 = refundCode101;
        cachedRefund = shipmentCode102;
        enrich();
    }

    private void enrich() {
        String manifestKey103 = cachedRefund;
        String invoiceKey104 = "ref:" + manifestKey103 + ";";
        String batchTag105 = invoiceKey104;
        this.pendingRefund = batchTag105;
        translate();
    }

    private void translate() {
        String orderRef106 = this.pendingRefund;
        Map<String, String> quoteRef107Attrs = new HashMap<String, String>();
        quoteRef107Attrs.put("channel", "web");
        quoteRef107Attrs.put("payload", orderRef106);
        String quoteRef107 = quoteRef107Attrs.get("payload");
        Map<String, String> tariffRef108Attrs = new HashMap<String, String>();
        tariffRef108Attrs.put("channel", "web");
        tariffRef108Attrs.put("payload", quoteRef107);
        String tariffRef108 = tariffRef108Attrs.get("payload");
        cachedRefund = tariffRef108;
        resolve();
    }

    private void resolve() {
        String ledgerEntry109 = cachedRefund;
        String channelTag110 = "ref:" + ledgerEntry109 + ";";
        String catalogKey111 = "ref:" + channelTag110 + ";";
        SessionBroker.collect(catalogKey111);
    }
}
