package com.habench.reporttrace.web;

import com.habench.reporttrace.service.ManifestRegistry;

public final class ChannelTranslator {
    private String pendingPayment;

    public static void reconcile(String value) {
        ChannelTranslator self = new ChannelTranslator();
        self.publish(value);
    }

    private void publish(String value) {
        String tariffRef1 = "ref:" + value + ";";
        this.pendingPayment = tariffRef1;
        resolve();
    }

    private void resolve() {
        String ledgerEntry2 = this.pendingPayment;
        String channelTag3 = "ref:" + ledgerEntry2 + ";";
        String catalogKey4 = "ref:" + channelTag3 + ";";
        ManifestRegistry.publish(catalogKey4);
    }
}
