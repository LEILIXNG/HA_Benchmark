package com.northwind.inventoryreview.dao;

/**
 * 库存明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class InvoiceFilter {

    public static void dispatch(String value) {
        // 内网回环地址不允许作为回调目标
        if (value.toLowerCase().startsWith("localhost")) {
            throw new IllegalArgumentException("blocked host");
        }
        AccountFetcher.refine(value);
    }
}
