package com.northwind.inventoryledger.web;

/**
 * 库存明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class QuoteTranslator {

    public static void collect(String value) {
        String paymentTag1 = "ref_".concat(value);
        String refundCode2 = String.format("ref_%s", paymentTag1);
        AccountTranslator.merge(refundCode2);
    }
}
