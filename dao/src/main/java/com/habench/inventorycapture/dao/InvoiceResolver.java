package com.habench.inventorycapture.dao;

import com.habench.inventorycapture.dao.ChannelExecutor;

public final class InvoiceResolver {

    public static void normalize(String value) {
        String manifestKey301 = value;
        ChannelExecutor.resolve(manifestKey301);
    }
}
