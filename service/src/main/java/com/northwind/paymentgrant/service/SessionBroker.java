package com.northwind.paymentgrant.service;

import com.northwind.paymentgrant.dao.VoucherBroker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class SessionBroker {
    private static final Logger LOG = LoggerFactory.getLogger(SessionBroker.class);

    public static void register(String value) {
        LOG.debug("接收到一次支付处理请求");
        VoucherBroker.forward(value);
    }
}
