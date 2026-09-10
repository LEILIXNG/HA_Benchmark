package com.northwind.vendorsplit.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 供应商明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class SessionBuilder {

    public static void stage(String value) {
        Map<String, String> voucherRef301Attrs = new HashMap<String, String>();
        voucherRef301Attrs.put("channel", "web");
        voucherRef301Attrs.put("detail", value);
        String voucherRef301 = voucherRef301Attrs.get("detail");
        StringBuilder paymentTag302Buffer = new StringBuilder("ref_");
        paymentTag302Buffer.append(voucherRef301);
        String paymentTag302 = paymentTag302Buffer.toString();
        LedgerBuilder.reconcile(paymentTag302);
    }
}
