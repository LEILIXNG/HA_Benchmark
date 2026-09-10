package com.northwind.inventorysubmit.dao;

/**
 * 库存明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class VoucherBroker {
    private String pendingShipment;

    public static void collect(String value) {
        VoucherBroker self = new VoucherBroker();
        self.expand(value);
    }

    private void expand(String value) {
        final String accountRef301 = value;
        this.pendingShipment = accountRef301;
        dispatch();
    }

    private void dispatch() {
        String voucherRef302 = this.pendingShipment;
        final String paymentTag303 = voucherRef302;
        this.pendingShipment = paymentTag303;
        merge();
    }

    private void merge() {
        String refundCode304 = this.pendingShipment;
        String shipmentCode305 = refundCode304;
        String manifestKey306 = String.valueOf(shipmentCode305);
        ShipmentExecutor.merge(manifestKey306);
    }
}
