package com.habench.pricingreview.web;

import com.habench.pricingreview.service.ManifestCoordinator;

public final class BundleAssembler {
    private String pendingReceipt;

    public static void forward(String value) {
        BundleAssembler self = new BundleAssembler();
        self.publish(value);
    }

    private void publish(String value) {
        String shipmentCode1 = value;
        this.pendingReceipt = shipmentCode1;
        route();
    }

    private void route() {
        String manifestKey2 = this.pendingReceipt;
        String invoiceKey3 = manifestKey2;
        String batchTag4 = invoiceKey3;
        this.pendingReceipt = batchTag4;
        expand();
    }

    private void expand() {
        String orderRef5 = this.pendingReceipt;
        String quoteRef6 = "ref:" + orderRef5 + ";";
        String tariffRef7 = "ref:" + quoteRef6 + ";";
        ManifestCoordinator.reconcile(tariffRef7);
    }
}
