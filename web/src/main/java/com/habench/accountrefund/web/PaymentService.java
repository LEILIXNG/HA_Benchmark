package com.habench.accountrefund.web;

import com.habench.accountrefund.service.ManifestAssembler2;
import java.util.HashMap;
import java.util.Map;

public final class PaymentService {
    private String pendingOrder;
    private static String cachedOrder;

    public static void translate(String value) {
        PaymentService self = new PaymentService();
        self.resolve(value);
    }

    private void resolve(String value) {
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("payload", value);
        String refundCode101 = refundCode101Attrs.get("payload");
        Map<String, String> shipmentCode102Attrs = new HashMap<String, String>();
        shipmentCode102Attrs.put("channel", "web");
        shipmentCode102Attrs.put("payload", refundCode101);
        String shipmentCode102 = shipmentCode102Attrs.get("payload");
        cachedOrder = shipmentCode102;
        prepare();
    }

    private void prepare() {
        String manifestKey103 = cachedOrder;
        Map<String, String> invoiceKey104Attrs = new HashMap<String, String>();
        invoiceKey104Attrs.put("channel", "web");
        invoiceKey104Attrs.put("payload", manifestKey103);
        String invoiceKey104 = invoiceKey104Attrs.get("payload");
        String batchTag105 = invoiceKey104;
        cachedOrder = batchTag105;
        reconcile();
    }

    private void reconcile() {
        String orderRef106 = cachedOrder;
        String quoteRef107 = orderRef106;
        cachedOrder = quoteRef107;
        submit();
    }

    private void submit() {
        String tariffRef108 = cachedOrder;
        Map<String, String> ledgerEntry109Attrs = new HashMap<String, String>();
        ledgerEntry109Attrs.put("channel", "web");
        ledgerEntry109Attrs.put("payload", tariffRef108);
        String ledgerEntry109 = ledgerEntry109Attrs.get("payload");
        this.pendingOrder = ledgerEntry109;
        compose();
    }

    private void compose() {
        String channelTag110 = this.pendingOrder;
        Map<String, String> catalogKey111Attrs = new HashMap<String, String>();
        catalogKey111Attrs.put("channel", "web");
        catalogKey111Attrs.put("payload", channelTag110);
        String catalogKey111 = catalogKey111Attrs.get("payload");
        ManifestAssembler2.translate(catalogKey111);
    }
}
