package com.northwind.paymenttransfer.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ShipmentBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentBuilder.class);

    public static void assemble(String value) {
        LOG.debug("支付流程转下一环节");
        String paymentTag501 = "ref:" + value + ";";
        String refundCode502 = String.valueOf(paymentTag501);
        InvoiceEvaluator.forward(refundCode502);
    }
}
