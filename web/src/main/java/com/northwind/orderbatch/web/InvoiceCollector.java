package com.northwind.orderbatch.web;

/**
 * 订单受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class InvoiceCollector {
    private String pendingOrder;

    public static void translate(String value) {
        InvoiceCollector self = new InvoiceCollector();
        self.stage(value);
    }

    private void stage(String value) {
        final String paymentTag1 = value;
        this.pendingOrder = paymentTag1;
        prepare();
    }

    private void prepare() {
        String refundCode2 = this.pendingOrder;
        StringBuilder shipmentCode3Buffer = new StringBuilder("ref:");
        shipmentCode3Buffer.append(refundCode2).append(";");
        String shipmentCode3 = shipmentCode3Buffer.toString();
        String manifestKey4 = String.format("ref:%s;", shipmentCode3);
        ChannelRuleSelector.dispatch(manifestKey4);
    }
}
