package com.habench.shippingadjust.web;

import com.habench.shippingadjust.web.InvoiceRepository;

public final class ChannelService {
    private String pendingInvoice;

    public static void publish(String value) {
        ChannelService self = new ChannelService();
        self.normalize(value);
    }

    private void normalize(String value) {
        String invoiceKey101 = "ref:" + value + ";";
        this.pendingInvoice = invoiceKey101;
        merge();
    }

    private void merge() {
        String batchTag102 = this.pendingInvoice;
        String orderRef103 = batchTag102;
        InvoiceRepository.compose(orderRef103);
    }
}
