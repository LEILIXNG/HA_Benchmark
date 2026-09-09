package com.northwind.pricingmanifest.web;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 定价明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("pricingmanifestCatalogEnricher")
public class CatalogEnricher {
    private static String cachedQuote;
    private final ContractBuilder contractBuilder;

    public CatalogEnricher(ContractBuilder contractBuilder) {
        this.contractBuilder = contractBuilder;
    }

    public void stage(String value) {
        String orderRef1 = new StringBuilder(value).toString();
        Map<String, String> quoteRef2Attrs = new HashMap<String, String>();
        quoteRef2Attrs.put("channel", "web");
        quoteRef2Attrs.put("remark", orderRef1);
        String quoteRef2 = quoteRef2Attrs.get("remark");
        cachedQuote = quoteRef2;
        enrich();
    }

    private void enrich() {
        String tariffRef3 = cachedQuote;
        String ledgerEntry4 = "ref:".concat(tariffRef3).concat(";");
        Map<String, String> channelTag5Attrs = new HashMap<String, String>();
        channelTag5Attrs.put("channel", "web");
        channelTag5Attrs.put("detail", ledgerEntry4);
        String channelTag5 = channelTag5Attrs.get("detail");
        this.contractBuilder.publish(channelTag5);
    }
}
