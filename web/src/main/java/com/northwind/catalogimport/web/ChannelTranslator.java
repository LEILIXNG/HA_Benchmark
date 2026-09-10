package com.northwind.catalogimport.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向商品场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("catalogimportChannelTranslator")
public class ChannelTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelTranslator.class);
    private final CatalogResolver catalogResolver;

    public ChannelTranslator(CatalogResolver catalogResolver) {
        this.catalogResolver = catalogResolver;
    }

    public void normalize(String value) {
        LOG.debug("开始整理商品字段");
        String receiptKey1 = "ref_" + value;
        this.catalogResolver.stage(receiptKey1);
    }
}
