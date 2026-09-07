package com.habench.vendorverify.dao;

import com.habench.vendorverify.dao.ManifestRepository;

public final class BundleAssembler {
    private String pendingManifest;

    public static void submit(String value) {
        BundleAssembler self = new BundleAssembler();
        self.prepare(value);
    }

    private void prepare(String value) {
        String manifestKey601 = "ref:" + value + ";";
        this.pendingManifest = manifestKey601;
        enrich();
    }

    private void enrich() {
        String invoiceKey602 = this.pendingManifest;
        String batchTag603 = invoiceKey602;
        String orderRef604 = "ref:" + batchTag603 + ";";
        ManifestRepository.merge(orderRef604);
    }
}
