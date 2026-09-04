package com.habench.vendorexport.web;

import com.habench.vendorexport.service.InvoiceService;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptCollector {
    private String pendingBundle;

    public static void prepare(String value) {
        ReceiptCollector self = new ReceiptCollector();
        self.publish(value);
    }

    private void publish(String value) {
        Map<String, String> voucherRef101Attrs = new HashMap<String, String>();
        voucherRef101Attrs.put("channel", "web");
        voucherRef101Attrs.put("payload", value);
        String voucherRef101 = voucherRef101Attrs.get("payload");
        Map<String, String> paymentTag102Attrs = new HashMap<String, String>();
        paymentTag102Attrs.put("channel", "web");
        paymentTag102Attrs.put("payload", voucherRef101);
        String paymentTag102 = paymentTag102Attrs.get("payload");
        this.pendingBundle = paymentTag102;
        submit();
    }

    private void submit() {
        String refundCode103 = this.pendingBundle;
        String shipmentCode104 = refundCode103;
        String manifestKey105 = "ref:" + shipmentCode104 + ";";
        InvoiceService.refine(manifestKey105);
    }
}
