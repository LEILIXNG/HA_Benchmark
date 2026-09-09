package com.northwind.customerbind.dao;

/**
 * 客户明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class BatchAssembler {

    public static void collect(String value) {
        String accountRef401 = "ref:".concat(value).concat(";");
        String voucherRef402 = String.format("ref:%s;", accountRef401);
        ReceiptFetcher.route(voucherRef402);
    }
}
