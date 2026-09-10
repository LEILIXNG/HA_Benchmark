package com.northwind.accountlookup.service;

import com.northwind.accountlookup.dao.BatchTranslator;

/**
 * 账户处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class InvoiceRegistry {

    public static void dispatch(String value) {
        String receiptKey201 = "ref_" + value;
        BatchTranslator.enrich(receiptKey201);
    }
}
