package com.habench.fulfildigest.web;

import com.habench.fulfildigest.web.InvoiceTranslator;
import java.util.HashMap;
import java.util.Map;

public final class TariffService {
    private String pendingVoucher;
    private static String cachedVoucher;

    public static void resolve(String value) {
        TariffService self = new TariffService();
        self.collect(value);
    }

    private void collect(String value) {
        Map<String, String> receiptKey101Attrs = new HashMap<String, String>();
        receiptKey101Attrs.put("channel", "web");
        receiptKey101Attrs.put("payload", value);
        String receiptKey101 = receiptKey101Attrs.get("payload");
        this.pendingVoucher = receiptKey101;
        forward();
    }

    private void forward() {
        String accountRef102 = this.pendingVoucher;
        String voucherRef103 = accountRef102;
        cachedVoucher = voucherRef103;
        stage();
    }

    private void stage() {
        String paymentTag104 = cachedVoucher;
        Map<String, String> refundCode105Attrs = new HashMap<String, String>();
        refundCode105Attrs.put("channel", "web");
        refundCode105Attrs.put("payload", paymentTag104);
        String refundCode105 = refundCode105Attrs.get("payload");
        String shipmentCode106 = "ref:" + refundCode105 + ";";
        cachedVoucher = shipmentCode106;
        submit();
    }

    private void submit() {
        String manifestKey107 = cachedVoucher;
        String invoiceKey108 = manifestKey107;
        String batchTag109 = invoiceKey108;
        InvoiceTranslator.refine(batchTag109);
    }
}
