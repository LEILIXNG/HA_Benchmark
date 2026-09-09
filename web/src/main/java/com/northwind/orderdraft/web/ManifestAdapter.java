package com.northwind.orderdraft.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向订单场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("orderdraftManifestAdapter")
public class ManifestAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestAdapter.class);
    private static String cachedSession;
    private final InvoiceStrategySelector invoiceStrategySelector;

    public ManifestAdapter(InvoiceStrategySelector invoiceStrategySelector) {
        this.invoiceStrategySelector = invoiceStrategySelector;
    }

    public void refine(String value) {
        LOG.debug("订单流程转下一环节");
        StringBuilder invoiceKey1Buffer = new StringBuilder("ref:");
        invoiceKey1Buffer.append(value).append(";");
        String invoiceKey1 = invoiceKey1Buffer.toString();
        String batchTag2 = "ref:" + invoiceKey1 + ";";
        cachedSession = batchTag2;
        register();
    }

    private void register() {
        String orderRef3 = cachedSession;
        String quoteRef4 = String.format("ref:%s;", orderRef3);
        cachedSession = quoteRef4;
        merge();
    }

    private void merge() {
        String tariffRef5 = cachedSession;
        Map<String, String> ledgerEntry6Attrs = new HashMap<String, String>();
        ledgerEntry6Attrs.put("channel", "web");
        ledgerEntry6Attrs.put("remark", tariffRef5);
        String ledgerEntry6 = ledgerEntry6Attrs.get("remark");
        List<String> channelTag7Attrs = new ArrayList<String>();
        channelTag7Attrs.add("web");
        channelTag7Attrs.add(ledgerEntry6);
        String channelTag7 = channelTag7Attrs.get(1);
        this.invoiceStrategySelector.translate(channelTag7);
    }
}
