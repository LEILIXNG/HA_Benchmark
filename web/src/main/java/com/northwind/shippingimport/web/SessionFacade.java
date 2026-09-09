package com.northwind.shippingimport.web;

import com.northwind.shippingimport.service.RefundBroker;

/**
 * 发运受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class SessionFacade {

    public static void normalize(String value) {
        String paymentTag1 = new StringBuilder(value).toString();
        RefundBroker.route(paymentTag1);
    }
}
