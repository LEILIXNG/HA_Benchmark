package com.northwind.vendorledger.web;

import com.northwind.vendorledger.service.CatalogRegistry;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 供应商明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("vendorledgerChannelFacade")
public class ChannelFacade {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelFacade.class);
    private String pendingChannel;
    private final CatalogRegistry catalogRegistry;

    public ChannelFacade(CatalogRegistry catalogRegistry) {
        this.catalogRegistry = catalogRegistry;
    }

    public void refine(String value) {
        LOG.debug("开始整理供应商字段");
        this.forward(value);
    }

    private void forward(String value) {
        Map<String, String> quoteRef101Attrs = new HashMap<String, String>();
        quoteRef101Attrs.put("channel", "web");
        quoteRef101Attrs.put("detail", value);
        String quoteRef101 = quoteRef101Attrs.get("detail");
        String tariffRef102 = String.format("ref:%s;", quoteRef101);
        this.pendingChannel = tariffRef102;
        enrich();
    }

    private void enrich() {
        String ledgerEntry103 = this.pendingChannel;
        String channelTag104 = "ref:" + ledgerEntry103 + ";";
        this.pendingChannel = channelTag104;
        register();
    }

    private void register() {
        String catalogKey105 = this.pendingChannel;
        final String receiptKey106 = catalogKey105;
        this.catalogRegistry.submit(receiptKey106);
    }
}
