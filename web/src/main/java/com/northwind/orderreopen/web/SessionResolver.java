package com.northwind.orderreopen.web;

import com.northwind.orderreopen.service.PaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class SessionResolver {
    private static final Logger LOG = LoggerFactory.getLogger(SessionResolver.class);

    public static void collect(String value) {
        LOG.debug("接收到一次订单处理请求");
        String shipmentCode1 = String.format("ref_%s", value);
        String manifestKey2 = "ref_".concat(shipmentCode1);
        PaymentService.register(manifestKey2);
    }
}
