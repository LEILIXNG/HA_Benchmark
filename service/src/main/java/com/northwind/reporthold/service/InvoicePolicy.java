package com.northwind.reporthold.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class InvoicePolicy {
    private static final Logger LOG = LoggerFactory.getLogger(InvoicePolicy.class);

    public static void prepare(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new IllegalArgumentException("rejected input");
        }
        ContractEvaluator.attach(value);
    }
}
