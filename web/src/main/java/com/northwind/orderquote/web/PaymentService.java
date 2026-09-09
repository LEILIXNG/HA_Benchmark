package com.northwind.orderquote.web;

import com.northwind.orderquote.service.OrderRouter;

/**
 * 订单明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class PaymentService {

    public static void resolve(String value) {
        String manifestKey101 = String.valueOf(value);
        OrderRouter.enrich(manifestKey101);
    }
}
