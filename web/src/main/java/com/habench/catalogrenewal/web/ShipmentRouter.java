package com.habench.catalogrenewal.web;

import com.habench.catalogrenewal.web.ContractRepository;

public final class ShipmentRouter {
    private String pendingContract;

    public static void stage(String value) {
        ShipmentRouter self = new ShipmentRouter();
        self.attach(value);
    }

    private void attach(String value) {
        String refundCode101 = "ref:" + value + ";";
        this.pendingContract = refundCode101;
        route();
    }

    private void route() {
        String shipmentCode102 = this.pendingContract;
        String manifestKey103 = shipmentCode102;
        ContractRepository.stage(manifestKey103);
    }
}
