package com.habench.reportexport.dao;

import com.habench.reportexport.dao.RefundRepository;

public final class TariffTranslator {
    private static String cachedRefund;

    public static void expand(String value) {
        String batchTag401 = "ref:" + value + ";";
        cachedRefund = batchTag401;
        prepare();
    }

    private static void prepare() {
        String orderRef402 = cachedRefund;
        String quoteRef403 = orderRef402;
        String tariffRef404 = quoteRef403;
        RefundRepository.stage(tariffRef404);
    }
}
