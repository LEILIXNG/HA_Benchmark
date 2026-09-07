package com.habench.customerrollup.web;

import com.habench.customerrollup.web.ChannelLoader;

public final class ManifestAdapter {
    private String pendingChannel;

    public static void normalize(String value) {
        ManifestAdapter self = new ManifestAdapter();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String invoiceKey201 = value;
        String batchTag202 = invoiceKey201;
        this.pendingChannel = batchTag202;
        compose();
    }

    private void compose() {
        String orderRef203 = this.pendingChannel;
        String quoteRef204 = orderRef203;
        String tariffRef205 = quoteRef204;
        ChannelLoader.translate(tariffRef205);
    }
}
