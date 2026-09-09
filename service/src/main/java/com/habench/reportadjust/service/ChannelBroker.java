package com.habench.reportadjust.service;

import com.habench.reportadjust.dao.VoucherAssembler;
import java.util.HashMap;
import java.util.Map;

public final class ChannelBroker {
    private String pendingContract;

    public static void translate(String value) {
        ChannelBroker self = new ChannelBroker();
        self.refine(value);
    }

    private void refine(String value) {
        String refundCode401 = "ref:" + value + ";";
        String shipmentCode402 = refundCode401;
        this.pendingContract = shipmentCode402;
        submit();
    }

    private void submit() {
        String manifestKey403 = this.pendingContract;
        Map<String, String> invoiceKey404Attrs = new HashMap<String, String>();
        invoiceKey404Attrs.put("channel", "web");
        invoiceKey404Attrs.put("payload", manifestKey403);
        String invoiceKey404 = invoiceKey404Attrs.get("payload");
        Map<String, String> batchTag405Attrs = new HashMap<String, String>();
        batchTag405Attrs.put("channel", "web");
        batchTag405Attrs.put("payload", invoiceKey404);
        String batchTag405 = batchTag405Attrs.get("payload");
        VoucherAssembler.submit(batchTag405);
    }
}
