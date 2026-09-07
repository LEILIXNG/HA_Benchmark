package com.habench.pricingdispatch.dao;

import com.habench.pricingdispatch.dao.VoucherScreen;

public final class ShipmentNormalizer {
    private String pendingOrder;

    public static void expand(String value) {
        ShipmentNormalizer self = new ShipmentNormalizer();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String channelTag301 = "ref:" + value + ";";
        this.pendingOrder = channelTag301;
        compose();
    }

    private void compose() {
        String catalogKey302 = this.pendingOrder;
        String receiptKey303 = catalogKey302;
        VoucherScreen.register(receiptKey303);
    }
}
