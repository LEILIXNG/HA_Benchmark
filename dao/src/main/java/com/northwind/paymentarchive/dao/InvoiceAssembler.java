package com.northwind.paymentarchive.dao;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 支付明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class InvoiceAssembler {

    public static void register(String value) {
        Map<String, String> ledgerEntry201Attrs = new LinkedHashMap<String, String>();
        ledgerEntry201Attrs.put("channel", "web");
        ledgerEntry201Attrs.put("detail", value);
        String ledgerEntry201 = ledgerEntry201Attrs.getOrDefault("detail", "");
        ReceiptComposer.merge(ledgerEntry201);
    }
}
