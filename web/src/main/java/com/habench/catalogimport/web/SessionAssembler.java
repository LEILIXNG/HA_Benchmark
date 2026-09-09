package com.habench.catalogimport.web;

import com.habench.catalogimport.web.BatchRepository;

public final class SessionAssembler {
    private String pendingBatch;

    public static void forward(String value) {
        SessionAssembler self = new SessionAssembler();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String shipmentCode201 = "ref:" + value + ";";
        String manifestKey202 = shipmentCode201;
        this.pendingBatch = manifestKey202;
        attach();
    }

    private void attach() {
        String invoiceKey203 = this.pendingBatch;
        String batchTag204 = invoiceKey203;
        BatchRepository.normalize(batchTag204);
    }
}
