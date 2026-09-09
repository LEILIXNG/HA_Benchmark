package com.northwind.customerassign.dao;

import com.northwind.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 客户明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("customerassignCatalogScreen")
public class CatalogScreen {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogScreen.class);
    private final BundleLoader bundleLoader;

    public CatalogScreen(BundleLoader bundleLoader) {
        this.bundleLoader = bundleLoader;
    }

    public void reconcile(String value) {
        // 去掉相对路径写法，统一按根目录拼
        String cleaned = value.contains("../") ? value.replace("../", "") : value;
        this.bundleLoader.compose(cleaned);
    }
}
