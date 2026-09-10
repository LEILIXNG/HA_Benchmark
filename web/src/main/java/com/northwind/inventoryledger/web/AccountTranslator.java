package com.northwind.inventoryledger.web;

import com.northwind.inventoryledger.service.TariffAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向库存场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class AccountTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(AccountTranslator.class);

    public static void merge(String value) {
        LOG.debug("接收到一次库存处理请求");
        String channelTag101 = String.format("ref_%s", value);
        String catalogKey102 = "ref_".concat(channelTag101);
        TariffAdapter.dispatch(catalogKey102);
    }
}
