package com.northwind.catalogreopen.dao;

/**
 * 商品明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ChannelCoordinator {

    public static void submit(String value) {
        String voucherRef201 = String.valueOf(value);
        SessionPolicy.assemble(voucherRef201);
    }
}
