package com.habench.paymentquote.service;

import com.habench.paymentquote.service.ContractRuleSelector;

public final class ShipmentResolver {
    private String pendingOrder;

    public static void compose(String value) {
        ShipmentResolver self = new ShipmentResolver();
        self.refine(value);
    }

    private void refine(String value) {
        String voucherRef101 = "ref:" + value + ";";
        String paymentTag102 = voucherRef101;
        this.pendingOrder = paymentTag102;
        forward();
    }

    private void forward() {
        String refundCode103 = this.pendingOrder;
        String shipmentCode104 = refundCode103;
        ContractRuleSelector.route(shipmentCode104);
    }
}
