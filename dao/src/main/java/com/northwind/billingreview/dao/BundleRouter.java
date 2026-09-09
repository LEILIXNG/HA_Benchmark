package com.northwind.billingreview.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 账务明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("billingreviewBundleRouter")
public class BundleRouter {
    private static final Logger LOG = LoggerFactory.getLogger(BundleRouter.class);
    private String pendingManifest;
    private final CatalogValidator catalogValidator;

    public BundleRouter(CatalogValidator catalogValidator) {
        this.catalogValidator = catalogValidator;
    }

    public void resolve(String value) {
        LOG.debug("接收到一次账务处理请求");
        this.collect(value);
    }

    private void collect(String value) {
        String orderRef301 = String.format("ref:%s;", value);
        this.pendingManifest = orderRef301;
        stage();
    }

    private void stage() {
        String quoteRef302 = this.pendingManifest;
        String tariffRef303 = String.valueOf(quoteRef302);
        this.pendingManifest = tariffRef303;
        reconcile();
    }

    private void reconcile() {
        String ledgerEntry304 = this.pendingManifest;
        String channelTag305 = new StringBuilder(ledgerEntry304).toString();
        final String catalogKey306 = channelTag305;
        this.catalogValidator.route(catalogKey306);
    }
}
