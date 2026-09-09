package com.northwind.vendorrelease.web;

import com.northwind.vendorrelease.service.QuoteRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("vendorreleaseManifestNormalizer")
public class ManifestNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestNormalizer.class);
    private final QuoteRegistry quoteRegistry;

    public ManifestNormalizer(QuoteRegistry quoteRegistry) {
        this.quoteRegistry = quoteRegistry;
    }

    public void assemble(String value) {
        LOG.debug("开始整理供应商字段");
        String tariffRef1 = new StringBuilder(value).toString();
        this.quoteRegistry.route(tariffRef1);
    }
}
