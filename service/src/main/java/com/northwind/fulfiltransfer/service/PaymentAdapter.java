package com.northwind.fulfiltransfer.service;

/**
 * 履约明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class PaymentAdapter {

    public static void translate(String value) {
        StringBuilder shipmentCode101Buffer = new StringBuilder("ref_");
        shipmentCode101Buffer.append(value);
        String shipmentCode101 = shipmentCode101Buffer.toString();
        String manifestKey102 = new StringBuilder(shipmentCode101).toString();
        ContractCollector.dispatch(manifestKey102);
    }
}
