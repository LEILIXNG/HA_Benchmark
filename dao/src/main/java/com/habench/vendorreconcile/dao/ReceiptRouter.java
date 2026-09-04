package com.habench.vendorreconcile.dao;

import com.habench.vendorreconcile.dao.BundleLoader;
import java.util.HashMap;
import java.util.Map;

public final class ReceiptRouter {
    private String pendingBundle;
    private static String cachedBundle;

    public static void assemble(String value) {
        ReceiptRouter self = new ReceiptRouter();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String accountRef301 = value;
        String voucherRef302 = accountRef301;
        cachedBundle = voucherRef302;
        prepare();
    }

    private void prepare() {
        String paymentTag303 = cachedBundle;
        Map<String, String> refundCode304Attrs = new HashMap<String, String>();
        refundCode304Attrs.put("channel", "web");
        refundCode304Attrs.put("payload", paymentTag303);
        String refundCode304 = refundCode304Attrs.get("payload");
        String shipmentCode305 = refundCode304;
        this.pendingBundle = shipmentCode305;
        collect();
    }

    private void collect() {
        String manifestKey306 = this.pendingBundle;
        Map<String, String> invoiceKey307Attrs = new HashMap<String, String>();
        invoiceKey307Attrs.put("channel", "web");
        invoiceKey307Attrs.put("payload", manifestKey306);
        String invoiceKey307 = invoiceKey307Attrs.get("payload");
        String batchTag308 = "ref:" + invoiceKey307 + ";";
        BundleLoader.resolve(batchTag308);
    }
}
