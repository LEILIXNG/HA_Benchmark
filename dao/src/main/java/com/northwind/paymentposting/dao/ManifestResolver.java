package com.northwind.paymentposting.dao;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ManifestResolver {

    public static void stage(String value) {
        Map<String, String> accountRef701Attrs = new HashMap<String, String>();
        accountRef701Attrs.put("channel", "web");
        accountRef701Attrs.put("detail", value);
        String accountRef701 = accountRef701Attrs.get("detail");
        String voucherRef702 = "ref:".concat(accountRef701).concat(";");
        SessionEvaluator.translate(voucherRef702);
    }
}
