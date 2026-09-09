package com.northwind.customerreview.web;

import com.northwind.customerreview.service.SessionRegistry;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 客户明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("customerreviewBatchResolver")
public class BatchResolver {
    private final SessionRegistry sessionRegistry;

    public BatchResolver(SessionRegistry sessionRegistry) {
        this.sessionRegistry = sessionRegistry;
    }

    public void enrich(String value) {
        Map<String, String> paymentTag201Attrs = new LinkedHashMap<String, String>();
        paymentTag201Attrs.put("channel", "web");
        paymentTag201Attrs.put("detail", value);
        String paymentTag201 = paymentTag201Attrs.getOrDefault("detail", "");
        this.sessionRegistry.collect(paymentTag201);
    }
}
