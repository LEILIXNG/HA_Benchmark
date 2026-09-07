package com.habench.inventoryrevise.dao;

import com.habench.inventoryrevise.dao.ChannelExecutor;

public final class ShipmentEnricher {
    private String pendingChannel;

    public static void dispatch(String value) {
        ShipmentEnricher self = new ShipmentEnricher();
        self.refine(value);
    }

    private void refine(String value) {
        String accountRef201 = "ref:" + value + ";";
        String voucherRef202 = accountRef201;
        this.pendingChannel = voucherRef202;
        collect();
    }

    private void collect() {
        String paymentTag203 = this.pendingChannel;
        String refundCode204 = paymentTag203;
        String shipmentCode205 = refundCode204;
        ChannelExecutor.submit(shipmentCode205);
    }
}
