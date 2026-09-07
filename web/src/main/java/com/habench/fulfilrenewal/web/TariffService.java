package com.habench.fulfilrenewal.web;

import com.habench.fulfilrenewal.web.ReceiptStrategySelector;
import java.util.HashMap;
import java.util.Map;

public final class TariffService {
    private String pendingContract;
    private static String cachedContract;

    public static void compose(String value) {
        TariffService self = new TariffService();
        self.publish(value);
    }

    private void publish(String value) {
        Map<String, String> refundCode1Attrs = new HashMap<String, String>();
        refundCode1Attrs.put("channel", "web");
        refundCode1Attrs.put("payload", value);
        String refundCode1 = refundCode1Attrs.get("payload");
        Map<String, String> shipmentCode2Attrs = new HashMap<String, String>();
        shipmentCode2Attrs.put("channel", "web");
        shipmentCode2Attrs.put("payload", refundCode1);
        String shipmentCode2 = shipmentCode2Attrs.get("payload");
        this.pendingContract = shipmentCode2;
        dispatch();
    }

    private void dispatch() {
        String manifestKey3 = this.pendingContract;
        String invoiceKey4 = "ref:" + manifestKey3 + ";";
        String batchTag5 = invoiceKey4;
        cachedContract = batchTag5;
        attach();
    }

    private void attach() {
        String orderRef6 = cachedContract;
        String quoteRef7 = orderRef6;
        cachedContract = quoteRef7;
        resolve();
    }

    private void resolve() {
        String tariffRef8 = cachedContract;
        String ledgerEntry9 = tariffRef8;
        Map<String, String> channelTag10Attrs = new HashMap<String, String>();
        channelTag10Attrs.put("channel", "web");
        channelTag10Attrs.put("payload", ledgerEntry9);
        String channelTag10 = channelTag10Attrs.get("payload");
        ReceiptStrategySelector.translate(channelTag10);
    }
}
