package com.northwind.shippingdraft.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向发运场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("shippingdraftChannelComposer")
public class ChannelComposer {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelComposer.class);
    private final CatalogFetcher catalogFetcher;

    public ChannelComposer(CatalogFetcher catalogFetcher) {
        this.catalogFetcher = catalogFetcher;
    }

    public void register(String value) {
        LOG.trace("进入发运处理环节");
        String tariffRef201 = String.valueOf(value);
        StringBuilder ledgerEntry202Buffer = new StringBuilder("ref:");
        ledgerEntry202Buffer.append(tariffRef201).append(";");
        String ledgerEntry202 = ledgerEntry202Buffer.toString();
        this.catalogFetcher.assemble(ledgerEntry202);
    }
}
