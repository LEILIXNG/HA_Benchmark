package com.habench.pricingbind.web;

import com.habench.pricingbind.service.AccountRouter;

public final class BundleTranslator {
    private String pendingReceipt;

    public static void expand(String value) {
        BundleTranslator self = new BundleTranslator();
        self.reconcile(value);
    }

    private void reconcile(String value) {
        String orderRef1 = value;
        this.pendingReceipt = orderRef1;
        publish();
    }

    private void publish() {
        String quoteRef2 = this.pendingReceipt;
        String tariffRef3 = quoteRef2;
        AccountRouter.translate(tariffRef3);
    }
}
