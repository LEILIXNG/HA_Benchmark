package com.northwind.reporttransfer.web;

import com.northwind.reporttransfer.service.QuoteNormalizer;

/**
 * 报表主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ShipmentTranslator {

    public static void submit(String value) {
        String paymentTag101 = new StringBuilder(value).toString();
        QuoteNormalizer.assemble(paymentTag101);
    }
}
