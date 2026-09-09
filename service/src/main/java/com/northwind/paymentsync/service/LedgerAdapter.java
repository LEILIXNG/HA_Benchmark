package com.northwind.paymentsync.service;

/**
 * 支付处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class LedgerAdapter {

    public static void stage(String value) {
        String shipmentCode101 = String.valueOf(value);
        StringBuilder manifestKey102Buffer = new StringBuilder("ref:");
        manifestKey102Buffer.append(shipmentCode101).append(";");
        String manifestKey102 = manifestKey102Buffer.toString();
        RefundPolicy.stage(manifestKey102);
    }
}
