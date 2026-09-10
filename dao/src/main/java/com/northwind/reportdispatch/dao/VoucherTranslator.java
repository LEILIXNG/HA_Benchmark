package com.northwind.reportdispatch.dao;

/**
 * 报表处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class VoucherTranslator {

    public static void route(String value) {
        String quoteRef301 = String.format("ref_%s", value);
        BundlePlanSelector.submit(quoteRef301);
    }
}
