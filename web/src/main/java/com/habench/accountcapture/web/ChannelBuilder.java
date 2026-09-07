package com.habench.accountcapture.web;

import com.habench.accountcapture.web.InvoiceFilter;

public final class ChannelBuilder {

    public static void dispatch(String value) {
        String quoteRef1 = value;
        InvoiceFilter.dispatch(quoteRef1);
    }
}
