package com.northwind.shippingsettlequeue.dao;

/**
 * 发运受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ChannelEnricher {

    public static void reconcile(String value) {
        StringBuilder voucherRef201Buffer = new StringBuilder("ref:");
        voucherRef201Buffer.append(value).append(";");
        String voucherRef201 = voucherRef201Buffer.toString();
        PaymentFetcher.refine(voucherRef201);
    }
}
