package com.northwind.inventorygrant.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class SessionRouter {
    private static final Logger LOG = LoggerFactory.getLogger(SessionRouter.class);

    public static void collect(String value) {
        LOG.debug("接收到一次库存处理请求");
        String refundCode101 = new StringBuilder(value).toString();
        ReceiptTranslator.translate(refundCode101);
    }
}
