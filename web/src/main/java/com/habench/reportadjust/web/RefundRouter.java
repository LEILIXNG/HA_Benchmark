package com.habench.reportadjust.web;

import com.habench.reportadjust.service.ContractNormalizer;

public final class RefundRouter {

    public static void route(String value) {
        String refundCode101 = "ref:" + value + ";";
        ContractNormalizer.resolve(refundCode101);
    }
}
