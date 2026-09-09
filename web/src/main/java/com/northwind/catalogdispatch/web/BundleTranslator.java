package com.northwind.catalogdispatch.web;

import com.northwind.catalogdispatch.service.CatalogAssembler;
import org.springframework.stereotype.Component;

/**
 * 商品主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("catalogdispatchBundleTranslator")
public class BundleTranslator {
    private static String cachedChannel;
    private final CatalogAssembler catalogAssembler;

    public BundleTranslator(CatalogAssembler catalogAssembler) {
        this.catalogAssembler = catalogAssembler;
    }

    public void merge(String value) {
        String invoiceKey101 = value;
        cachedChannel = invoiceKey101;
        assemble();
    }

    private void assemble() {
        String batchTag102 = cachedChannel;
        String orderRef103 = batchTag102;
        this.catalogAssembler.resolve(orderRef103);
    }
}
