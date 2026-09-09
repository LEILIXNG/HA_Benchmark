package com.northwind.pricingadjust.web;

import com.northwind.pricingadjust.service.CatalogBroker;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定价明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("pricingadjustBatchEnricher")
public class BatchEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(BatchEnricher.class);
    private final CatalogBroker catalogBroker;

    public BatchEnricher(CatalogBroker catalogBroker) {
        this.catalogBroker = catalogBroker;
    }

    public void collect(String value) {
        LOG.trace("进入定价处理环节");
        Map<String, String> receiptKey101Attrs = new HashMap<String, String>();
        receiptKey101Attrs.put("channel", "web");
        receiptKey101Attrs.put("detail", value);
        String receiptKey101 = receiptKey101Attrs.get("detail");
        this.catalogBroker.stage(receiptKey101);
    }
}
