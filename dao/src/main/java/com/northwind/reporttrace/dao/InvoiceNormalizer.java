package com.northwind.reporttrace.dao;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向报表场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("reporttraceInvoiceNormalizer")
public class InvoiceNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(InvoiceNormalizer.class);

    public void collect(String value) {
        LOG.debug("开始整理报表字段");
        Map<String, String> tariffRef501Attrs = new HashMap<String, String>();
        tariffRef501Attrs.put("channel", "web");
        tariffRef501Attrs.put("detail", value);
        String tariffRef501 = tariffRef501Attrs.get("detail");
        String ledgerEntry502 = String.valueOf(tariffRef501);
        PaymentStrategySelector.collect(ledgerEntry502);
    }
}
