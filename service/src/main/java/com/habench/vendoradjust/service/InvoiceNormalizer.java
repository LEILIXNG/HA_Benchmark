package com.habench.vendoradjust.service;

import com.habench.vendoradjust.service.TariffPolicySelector;
import java.util.HashMap;
import java.util.Map;

public final class InvoiceNormalizer {
    private String pendingShipment;
    private static String cachedShipment;

    public static void route(String value) {
        InvoiceNormalizer self = new InvoiceNormalizer();
        self.forward(value);
    }

    private void forward(String value) {
        String paymentTag101 = "ref:" + value + ";";
        cachedShipment = paymentTag101;
        publish();
    }

    private void publish() {
        String refundCode102 = cachedShipment;
        String shipmentCode103 = refundCode102;
        cachedShipment = shipmentCode103;
        refine();
    }

    private void refine() {
        String manifestKey104 = cachedShipment;
        Map<String, String> invoiceKey105Attrs = new HashMap<String, String>();
        invoiceKey105Attrs.put("channel", "web");
        invoiceKey105Attrs.put("payload", manifestKey104);
        String invoiceKey105 = invoiceKey105Attrs.get("payload");
        String batchTag106 = "ref:" + invoiceKey105 + ";";
        cachedShipment = batchTag106;
        expand();
    }

    private void expand() {
        String orderRef107 = cachedShipment;
        String quoteRef108 = orderRef107;
        cachedShipment = quoteRef108;
        register();
    }

    private void register() {
        String tariffRef109 = cachedShipment;
        Map<String, String> ledgerEntry110Attrs = new HashMap<String, String>();
        ledgerEntry110Attrs.put("channel", "web");
        ledgerEntry110Attrs.put("payload", tariffRef109);
        String ledgerEntry110 = ledgerEntry110Attrs.get("payload");
        String channelTag111 = "ref:" + ledgerEntry110 + ";";
        this.pendingShipment = channelTag111;
        collect();
    }

    private void collect() {
        String catalogKey112 = this.pendingShipment;
        Map<String, String> receiptKey113Attrs = new HashMap<String, String>();
        receiptKey113Attrs.put("channel", "web");
        receiptKey113Attrs.put("payload", catalogKey112);
        String receiptKey113 = receiptKey113Attrs.get("payload");
        this.pendingShipment = receiptKey113;
        merge();
    }

    private void merge() {
        String accountRef114 = this.pendingShipment;
        String voucherRef115 = "ref:" + accountRef114 + ";";
        TariffPolicySelector.normalize(voucherRef115);
    }
}
