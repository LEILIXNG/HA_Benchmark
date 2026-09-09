package com.habench.reportquote.service;

import com.habench.reportquote.service.QuotePlanSelector;
import java.util.HashMap;
import java.util.Map;

public final class ChannelService {
    private String pendingCatalog;

    public static void resolve(String value) {
        ChannelService self = new ChannelService();
        self.forward(value);
    }

    private void forward(String value) {
        String refundCode201 = value;
        String shipmentCode202 = refundCode201;
        this.pendingCatalog = shipmentCode202;
        attach();
    }

    private void attach() {
        String manifestKey203 = this.pendingCatalog;
        String invoiceKey204 = manifestKey203;
        this.pendingCatalog = invoiceKey204;
        merge();
    }

    private void merge() {
        String batchTag205 = this.pendingCatalog;
        Map<String, String> orderRef206Attrs = new HashMap<String, String>();
        orderRef206Attrs.put("channel", "web");
        orderRef206Attrs.put("payload", batchTag205);
        String orderRef206 = orderRef206Attrs.get("payload");
        String quoteRef207 = "ref:" + orderRef206 + ";";
        this.pendingCatalog = quoteRef207;
        refine();
    }

    private void refine() {
        String tariffRef208 = this.pendingCatalog;
        String ledgerEntry209 = "ref:" + tariffRef208 + ";";
        Map<String, String> channelTag210Attrs = new HashMap<String, String>();
        channelTag210Attrs.put("channel", "web");
        channelTag210Attrs.put("payload", ledgerEntry209);
        String channelTag210 = channelTag210Attrs.get("payload");
        QuotePlanSelector.compose(channelTag210);
    }
}
