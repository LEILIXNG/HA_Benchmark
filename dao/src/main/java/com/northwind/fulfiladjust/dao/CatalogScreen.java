package com.northwind.fulfiladjust.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 履约明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("fulfiladjustCatalogScreen")
public class CatalogScreen {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogScreen.class);
    private final OrderLoader orderLoader;

    public CatalogScreen(OrderLoader orderLoader) {
        this.orderLoader = orderLoader;
    }

    public void reconcile(String value) {
        // 去掉相对路径写法，统一按根目录拼
        String cleaned = value.replace("../", "");
        this.orderLoader.submit(cleaned);
    }
}
