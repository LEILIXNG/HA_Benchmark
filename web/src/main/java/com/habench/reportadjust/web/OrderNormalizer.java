package com.habench.reportadjust.web;

import com.habench.reportadjust.web.SessionEnricher;
import java.util.HashMap;
import java.util.Map;

public final class OrderNormalizer {
    private String pendingContract;

    public static void compose(String value) {
        OrderNormalizer self = new OrderNormalizer();
        self.refine(value);
    }

    private void refine(String value) {
        String refundCode101 = "ref:" + value + ";";
        this.pendingContract = refundCode101;
        resolve();
    }

    private void resolve() {
        String shipmentCode102 = this.pendingContract;
        String manifestKey103 = "ref:" + shipmentCode102 + ";";
        String invoiceKey104 = "ref:" + manifestKey103 + ";";
        this.pendingContract = invoiceKey104;
        translate();
    }

    private void translate() {
        String batchTag105 = this.pendingContract;
        String orderRef106 = "ref:" + batchTag105 + ";";
        Map<String, String> quoteRef107Attrs = new HashMap<String, String>();
        quoteRef107Attrs.put("channel", "web");
        quoteRef107Attrs.put("payload", orderRef106);
        String quoteRef107 = quoteRef107Attrs.get("payload");
        this.pendingContract = quoteRef107;
        attach();
    }

    private void attach() {
        String tariffRef108 = this.pendingContract;
        String ledgerEntry109 = tariffRef108;
        String channelTag110 = "ref:" + ledgerEntry109 + ";";
        SessionEnricher.dispatch(channelTag110);
    }
}
