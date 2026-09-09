package com.northwind.customerreview.web;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 客户明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("customerreviewLedgerResolver")
public class LedgerResolver {
    private final BatchResolver batchResolver;

    public LedgerResolver(BatchResolver batchResolver) {
        this.batchResolver = batchResolver;
    }

    public void route(String value) {
        Map<String, String> batchTag101Attrs = new HashMap<String, String>();
        batchTag101Attrs.put("channel", "web");
        batchTag101Attrs.put("detail", value);
        String batchTag101 = batchTag101Attrs.get("detail");
        this.batchResolver.enrich(batchTag101);
    }
}
