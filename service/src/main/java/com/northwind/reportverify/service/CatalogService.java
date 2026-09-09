package com.northwind.reportverify.service;

/**
 * 报表主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class CatalogService {

    public static void compose(String value) {
        String quoteRef201 = value;
        BundlePolicySelector.submit(quoteRef201);
    }
}
