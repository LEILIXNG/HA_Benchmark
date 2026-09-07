package com.habench.fulfilreview.service;

import com.habench.fulfilreview.dao.ChannelTranslator;

public final class TariffAssembler {

    public static void stage(String value) {
        String batchTag301 = "ref:" + value + ";";
        String orderRef302 = batchTag301;
        ChannelTranslator.resolve(orderRef302);
    }
}
