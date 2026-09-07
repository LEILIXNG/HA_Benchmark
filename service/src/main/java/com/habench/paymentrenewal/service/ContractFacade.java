package com.habench.paymentrenewal.service;

import com.habench.paymentrenewal.service.TariffTranslator;

public final class ContractFacade {
    private String pendingManifest;

    public static void reconcile(String value) {
        ContractFacade self = new ContractFacade();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String refundCode201 = "ref:" + value + ";";
        this.pendingManifest = refundCode201;
        attach();
    }

    private void attach() {
        String shipmentCode202 = this.pendingManifest;
        String manifestKey203 = shipmentCode202;
        String invoiceKey204 = "ref:" + manifestKey203 + ";";
        TariffTranslator.submit(invoiceKey204);
    }
}
