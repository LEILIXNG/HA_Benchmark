package com.northwind.fulfiltransfer.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向履约场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class QuoteRouter {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteRouter.class);

    public static void route(String value) {
        LOG.debug("接收到一次履约处理请求");
        StringBuilder receiptKey501Buffer = new StringBuilder("ref:");
        receiptKey501Buffer.append(value).append(";");
        String receiptKey501 = receiptKey501Buffer.toString();
        String accountRef502 = "ref:" + receiptKey501 + ";";
        RefundBroker.enrich(accountRef502);
    }
}
