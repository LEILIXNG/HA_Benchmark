package com.habench.billingsettlequeue.web;

import com.habench.billingsettlequeue.service.InvoiceAssembler;
import java.util.HashMap;
import java.util.Map;

public final class OrderAssembler {
    private String pendingTariff;
    private static String cachedTariff;

    public static void translate(String value) {
        OrderAssembler self = new OrderAssembler();
        self.refine(value);
    }

    private void refine(String value) {
        String invoiceKey201 = value;
        this.pendingTariff = invoiceKey201;
        merge();
    }

    private void merge() {
        String batchTag202 = this.pendingTariff;
        Map<String, String> orderRef203Attrs = new HashMap<String, String>();
        orderRef203Attrs.put("channel", "web");
        orderRef203Attrs.put("payload", batchTag202);
        String orderRef203 = orderRef203Attrs.get("payload");
        String quoteRef204 = orderRef203;
        cachedTariff = quoteRef204;
        publish();
    }

    private void publish() {
        String tariffRef205 = cachedTariff;
        String ledgerEntry206 = "ref:" + tariffRef205 + ";";
        String channelTag207 = "ref:" + ledgerEntry206 + ";";
        InvoiceAssembler.publish(channelTag207);
    }
}
