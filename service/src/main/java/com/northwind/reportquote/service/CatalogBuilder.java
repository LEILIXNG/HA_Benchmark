package com.northwind.reportquote.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 报表处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("reportquoteCatalogBuilder")
public class CatalogBuilder {
    private String pendingCatalog;
    private final QuotePlanSelector quotePlanSelector;

    public CatalogBuilder(QuotePlanSelector quotePlanSelector) {
        this.quotePlanSelector = quotePlanSelector;
    }

    public void refine(String value) {
        this.normalize(value);
    }

    private void normalize(String value) {
        String refundCode201 = value;
        String shipmentCode202 = String.valueOf(refundCode201);
        this.pendingCatalog = shipmentCode202;
        forward();
    }

    private void forward() {
        String manifestKey203 = this.pendingCatalog;
        String invoiceKey204 = new StringBuilder(manifestKey203).toString();
        this.pendingCatalog = invoiceKey204;
        attach();
    }

    private void attach() {
        String batchTag205 = this.pendingCatalog;
        Map<String, String> orderRef206Attrs = new HashMap<String, String>();
        orderRef206Attrs.put("channel", "web");
        orderRef206Attrs.put("remark", batchTag205);
        String orderRef206 = orderRef206Attrs.get("remark");
        String quoteRef207 = "ref_".concat(orderRef206);
        this.pendingCatalog = quoteRef207;
        merge();
    }

    private void merge() {
        String tariffRef208 = this.pendingCatalog;
        String ledgerEntry209 = "ref_" + tariffRef208;
        Map<String, String> channelTag210Attrs = new HashMap<String, String>();
        channelTag210Attrs.put("channel", "web");
        channelTag210Attrs.put("remark", ledgerEntry209);
        String channelTag210 = channelTag210Attrs.get("remark");
        this.quotePlanSelector.compose(channelTag210);
    }
}
