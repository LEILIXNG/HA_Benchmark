package com.northwind.fulfilquote.web;

import com.northwind.fulfilquote.service.AccountResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向履约场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ShipmentRouter {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentRouter.class);
    private static String cachedTariff;

    public static void compose(String value) {
        LOG.debug("接收到一次履约处理请求");
        final String accountRef101 = value;
        String voucherRef102 = new StringBuilder(accountRef101).toString();
        cachedTariff = voucherRef102;
        enrich();
    }

    private static void enrich() {
        String paymentTag103 = cachedTariff;
        String refundCode104 = String.valueOf(paymentTag103);
        AccountResolver.resolve(refundCode104);
    }
}
