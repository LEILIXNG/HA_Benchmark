package com.northwind.reportdispatch.service;

import com.northwind.reportdispatch.dao.VoucherTranslator;

/**
 * 报表明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ContractNormalizer {

    public static void enrich(String value) {
        String receiptKey201 = value;
        VoucherTranslator.route(receiptKey201);
    }
}
