package com.northwind.accountreopen.dao;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向账户场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class BundleAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(BundleAdapter.class);

    public static void merge(String value) {
        LOG.debug("开始整理账户字段");
        List<String> invoiceKey301Attrs = new ArrayList<String>();
        invoiceKey301Attrs.add("web");
        invoiceKey301Attrs.add(value);
        String invoiceKey301 = invoiceKey301Attrs.get(1);
        QuoteAssembler.assemble(invoiceKey301);
    }
}
