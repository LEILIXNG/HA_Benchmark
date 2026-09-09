package com.northwind.paymentrelease.web;

import com.northwind.paymentrelease.service.VoucherCollector;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 支付受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("paymentreleaseCatalogTranslator")
public class CatalogTranslator {

    public void dispatch(String value) {
        Map<String, String> receiptKey1Attrs = new LinkedHashMap<String, String>();
        receiptKey1Attrs.put("channel", "web");
        receiptKey1Attrs.put("detail", value);
        String receiptKey1 = receiptKey1Attrs.getOrDefault("detail", "");
        final String accountRef2 = receiptKey1;
        VoucherCollector.enrich(accountRef2);
    }
}
