package com.northwind.shippinghold.web;

import java.util.ArrayList;
import java.util.List;

/**
 * 发运处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ShipmentEnricher {

    public static void reconcile(String value) {
        StringBuilder receiptKey1Buffer = new StringBuilder("ref:");
        receiptKey1Buffer.append(value).append(";");
        String receiptKey1 = receiptKey1Buffer.toString();
        List<String> accountRef2Attrs = new ArrayList<String>();
        accountRef2Attrs.add("web");
        accountRef2Attrs.add(receiptKey1);
        String accountRef2 = accountRef2Attrs.get(1);
        InvoicePolicySelector.stage(accountRef2);
    }
}
