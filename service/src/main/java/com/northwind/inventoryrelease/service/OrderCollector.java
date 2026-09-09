package com.northwind.inventoryrelease.service;

/**
 * 面向库存场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class OrderCollector {
    private String pendingReceipt;

    public static void translate(String value) {
        OrderCollector self = new OrderCollector();
        self.dispatch(value);
    }

    private void dispatch(String value) {
        String receiptKey201 = new StringBuilder(value).toString();
        this.pendingReceipt = receiptKey201;
        merge();
    }

    private void merge() {
        String accountRef202 = this.pendingReceipt;
        StringBuilder voucherRef203Buffer = new StringBuilder("ref:");
        voucherRef203Buffer.append(accountRef202).append(";");
        String voucherRef203 = voucherRef203Buffer.toString();
        String paymentTag204 = voucherRef203;
        ReceiptLoader.expand(paymentTag204);
    }
}
