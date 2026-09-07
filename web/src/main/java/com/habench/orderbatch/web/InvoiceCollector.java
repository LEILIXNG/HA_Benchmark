package com.habench.orderbatch.web;

import com.habench.orderbatch.web.ChannelRuleSelector;

public final class InvoiceCollector {
    private String pendingOrder;

    public static void translate(String value) {
        InvoiceCollector self = new InvoiceCollector();
        self.stage(value);
    }

    private void stage(String value) {
        String paymentTag1 = value;
        this.pendingOrder = paymentTag1;
        prepare();
    }

    private void prepare() {
        String refundCode2 = this.pendingOrder;
        String shipmentCode3 = "ref:" + refundCode2 + ";";
        String manifestKey4 = "ref:" + shipmentCode3 + ";";
        ChannelRuleSelector.dispatch(manifestKey4);
    }
}
