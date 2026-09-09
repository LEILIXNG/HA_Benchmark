package com.habench.ordercapture.service;

import com.habench.ordercapture.dao.RefundEnricher;

public final class RefundAssembler {

    public static void normalize(String value) {
        String quoteRef301 = "ref:" + value + ";";
        RefundEnricher.resolve(quoteRef301);
    }
}
