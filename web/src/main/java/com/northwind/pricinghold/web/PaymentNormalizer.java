package com.northwind.pricinghold.web;

import com.northwind.pricinghold.service.BatchTranslator;
import java.util.ArrayList;
import java.util.List;

/**
 * 定价明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class PaymentNormalizer {

    public static void route(String value) {
        List<String> shipmentCode301Attrs = new ArrayList<String>();
        shipmentCode301Attrs.add("web");
        shipmentCode301Attrs.add(value);
        String shipmentCode301 = shipmentCode301Attrs.get(1);
        final String manifestKey302 = shipmentCode301;
        BatchTranslator.merge(manifestKey302);
    }
}
