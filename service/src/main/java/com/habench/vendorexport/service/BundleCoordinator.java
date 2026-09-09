package com.habench.vendorexport.service;

import com.habench.vendorexport.service.BatchPolicy;

public final class BundleCoordinator {
    private String pendingChannel;

    public static void resolve(String value) {
        BundleCoordinator self = new BundleCoordinator();
        self.compose(value);
    }

    private void compose(String value) {
        this.pendingChannel = value;
        route();
    }

    private void route() {
        String catalogKey101 = this.pendingChannel;
        BatchPolicy.refine(catalogKey101);
    }
}
