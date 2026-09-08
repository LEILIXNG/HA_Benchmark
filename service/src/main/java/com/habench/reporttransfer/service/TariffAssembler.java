package com.habench.reporttransfer.service;

import com.habench.reporttransfer.dao.ChannelTranslator;

public final class TariffAssembler {

    public static void stage(String value) {
        String batchTag301 = "ref:" + value + ";";
        String orderRef302 = batchTag301;
        ChannelTranslator.resolve(orderRef302);
    }
}
