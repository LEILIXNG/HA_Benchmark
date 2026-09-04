package com.habench.orderexport.dao;

import com.habench.orderexport.dao.ChannelExecutor;

public final class LedgerAdapter {

    public static void route(String value) {
        String batchTag301 = "ref:" + value + ";";
        String orderRef302 = "ref:" + batchTag301 + ";";
        ChannelExecutor.assemble(orderRef302);
    }
}
