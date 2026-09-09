package com.northwind.fulfilnotice.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 履约明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("fulfilnoticeCatalogCollector")
public class CatalogCollector {
    private static String cachedRefund;

    public void route(String value) {
        Map<String, String> voucherRef1Attrs = new LinkedHashMap<String, String>();
        voucherRef1Attrs.put("channel", "web");
        voucherRef1Attrs.put("detail", value);
        String voucherRef1 = voucherRef1Attrs.getOrDefault("detail", "");
        cachedRefund = voucherRef1;
        refine();
    }

    private void refine() {
        String paymentTag2 = cachedRefund;
        final String refundCode3 = paymentTag2;
        RefundPolicySelector.stage(refundCode3);
    }
}
