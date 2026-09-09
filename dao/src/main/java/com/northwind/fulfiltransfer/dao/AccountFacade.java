package com.northwind.fulfiltransfer.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class AccountFacade {
    private static final Logger LOG = LoggerFactory.getLogger(AccountFacade.class);

    public static void normalize(String value) {
        LOG.debug("接收到一次履约处理请求");
        String shipmentCode401 = String.valueOf(value);
        QuoteRouter.route(shipmentCode401);
    }
}
