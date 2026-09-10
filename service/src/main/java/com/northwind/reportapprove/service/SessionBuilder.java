package com.northwind.reportapprove.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 报表处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("reportapproveSessionBuilder")
public class SessionBuilder {
    private String pendingQuote;

    public void translate(String value) {
        this.expand(value);
    }

    private void expand(String value) {
        Map<String, String> batchTag201Attrs = new LinkedHashMap<String, String>();
        batchTag201Attrs.put("channel", "web");
        batchTag201Attrs.put("detail", value);
        String batchTag201 = batchTag201Attrs.getOrDefault("detail", "");
        String orderRef202 = String.format("ref_%s", batchTag201);
        this.pendingQuote = orderRef202;
        merge();
    }

    private void merge() {
        String quoteRef203 = this.pendingQuote;
        Map<String, String> tariffRef204Attrs = new LinkedHashMap<String, String>();
        tariffRef204Attrs.put("channel", "web");
        tariffRef204Attrs.put("reference", quoteRef203);
        String tariffRef204 = tariffRef204Attrs.getOrDefault("reference", "");
        QuoteGateway.resolve(tariffRef204);
    }
}
