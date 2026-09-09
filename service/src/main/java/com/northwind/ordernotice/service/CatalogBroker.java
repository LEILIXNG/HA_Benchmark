package com.northwind.ordernotice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向订单场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("ordernoticeCatalogBroker")
public class CatalogBroker {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogBroker.class);
    private final OrderNormalizer orderNormalizer;

    public CatalogBroker(OrderNormalizer orderNormalizer) {
        this.orderNormalizer = orderNormalizer;
    }

    public void compose(String value) {
        LOG.debug("开始整理订单字段");
        StringBuilder batchTag201Buffer = new StringBuilder("ref:");
        batchTag201Buffer.append(value).append(";");
        String batchTag201 = batchTag201Buffer.toString();
        this.orderNormalizer.dispatch(batchTag201);
    }
}
