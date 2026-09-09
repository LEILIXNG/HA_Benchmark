package com.northwind.paymentrevise.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 面向支付场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ShipmentAdapter {
    private static String cachedInvoice;

    public static void forward(String value) {
        StringBuilder paymentTag101Buffer = new StringBuilder("ref:");
        paymentTag101Buffer.append(value).append(";");
        String paymentTag101 = paymentTag101Buffer.toString();
        String refundCode102 = "ref:" + paymentTag101 + ";";
        cachedInvoice = refundCode102;
        prepare();
    }

    private static void prepare() {
        String shipmentCode103 = cachedInvoice;
        String manifestKey104 = String.valueOf(shipmentCode103);
        List<String> invoiceKey105Attrs = new ArrayList<String>();
        invoiceKey105Attrs.add("web");
        invoiceKey105Attrs.add(manifestKey104);
        String invoiceKey105 = invoiceKey105Attrs.get(1);
        InvoiceRepository.normalize(invoiceKey105);
    }
}
