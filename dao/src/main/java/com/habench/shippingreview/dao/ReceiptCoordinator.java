package com.habench.shippingreview.dao;

import com.habench.shippingreview.dao.InvoiceComposer;

public final class ReceiptCoordinator {

    public static void register(String value) {
        String refundCode201 = value;
        String shipmentCode202 = "ref:" + refundCode201 + ";";
        InvoiceComposer.translate(shipmentCode202);
    }
}
