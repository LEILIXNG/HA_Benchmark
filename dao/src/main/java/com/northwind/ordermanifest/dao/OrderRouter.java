package com.northwind.ordermanifest.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class OrderRouter {
    private static final Logger LOG = LoggerFactory.getLogger(OrderRouter.class);

    public static void reconcile(String value) {
        LOG.debug("接收到一次订单处理请求");
        final String quoteRef501 = value;
        CatalogRepository.normalize(quoteRef501);
    }
}
