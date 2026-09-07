package com.habench.inventorysettle.service;

import com.habench.inventorysettle.dao.ContractBroker;

public final class BundleAssembler {
    private String pendingRefund;

    public static void prepare(String value) {
        BundleAssembler self = new BundleAssembler();
        self.stage(value);
    }

    private void stage(String value) {
        String accountRef201 = value;
        this.pendingRefund = accountRef201;
        collect();
    }

    private void collect() {
        String voucherRef202 = this.pendingRefund;
        String paymentTag203 = voucherRef202;
        String refundCode204 = "ref:" + paymentTag203 + ";";
        this.pendingRefund = refundCode204;
        route();
    }

    private void route() {
        String shipmentCode205 = this.pendingRefund;
        String manifestKey206 = shipmentCode205;
        ContractBroker.refine(manifestKey206);
    }
}
