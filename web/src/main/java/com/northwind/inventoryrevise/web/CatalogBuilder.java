package com.northwind.inventoryrevise.web;

import com.northwind.inventoryrevise.service.BundleBuilder;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向库存场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("inventoryreviseCatalogBuilder")
public class CatalogBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogBuilder.class);
    private String pendingPayment;
    private final BundleBuilder bundleBuilder;

    public CatalogBuilder(BundleBuilder bundleBuilder) {
        this.bundleBuilder = bundleBuilder;
    }

    public void translate(String value) {
        LOG.trace("进入库存处理环节");
        this.expand(value);
    }

    private void expand(String value) {
        String quoteRef1 = new StringBuilder(value).toString();
        Map<String, String> tariffRef2Attrs = new HashMap<String, String>();
        tariffRef2Attrs.put("channel", "web");
        tariffRef2Attrs.put("remark", quoteRef1);
        String tariffRef2 = tariffRef2Attrs.get("remark");
        this.pendingPayment = tariffRef2;
        stage();
    }

    private void stage() {
        String ledgerEntry3 = this.pendingPayment;
        String channelTag4 = ledgerEntry3;
        StringBuilder catalogKey5Buffer = new StringBuilder("ref:");
        catalogKey5Buffer.append(channelTag4).append(";");
        String catalogKey5 = catalogKey5Buffer.toString();
        this.bundleBuilder.merge(catalogKey5);
    }
}
