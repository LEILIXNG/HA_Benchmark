package com.habench.paymentrevise.service;

import com.habench.paymentrevise.service.InvoiceRepository;
import java.util.HashMap;
import java.util.Map;

public final class ShipmentAdapter {
    private static String cachedInvoice;

    public static void forward(String value) {
        String paymentTag101 = "ref:" + value + ";";
        String refundCode102 = "ref:" + paymentTag101 + ";";
        cachedInvoice = refundCode102;
        prepare();
    }

    private static void prepare() {
        String shipmentCode103 = cachedInvoice;
        String manifestKey104 = shipmentCode103;
        Map<String, String> invoiceKey105Attrs = new HashMap<String, String>();
        invoiceKey105Attrs.put("channel", "web");
        invoiceKey105Attrs.put("payload", manifestKey104);
        String invoiceKey105 = invoiceKey105Attrs.get("payload");
        InvoiceRepository.normalize(invoiceKey105);
    }
}
