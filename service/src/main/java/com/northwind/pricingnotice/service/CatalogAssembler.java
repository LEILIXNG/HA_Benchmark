package com.northwind.pricingnotice.service;

import org.springframework.stereotype.Service;

/**
 * 定价处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("pricingnoticeCatalogAssembler")
public class CatalogAssembler {
    private final CatalogTranslator catalogTranslator;

    public CatalogAssembler(CatalogTranslator catalogTranslator) {
        this.catalogTranslator = catalogTranslator;
    }

    public void merge(String value) {
        String invoiceKey301 = new StringBuilder(value).toString();
        this.catalogTranslator.register(invoiceKey301);
    }
}
