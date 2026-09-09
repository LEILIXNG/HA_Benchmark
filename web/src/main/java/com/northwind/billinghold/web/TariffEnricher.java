package com.northwind.billinghold.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账务受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("billingholdTariffEnricher")
public class TariffEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(TariffEnricher.class);
    private final InvoiceTranslator2 invoiceTranslator2;

    public TariffEnricher(InvoiceTranslator2 invoiceTranslator2) {
        this.invoiceTranslator2 = invoiceTranslator2;
    }

    public void translate(String value) {
        LOG.debug("开始整理账务字段");
        Map<String, String> manifestKey1Attrs = new HashMap<String, String>();
        manifestKey1Attrs.put("channel", "web");
        manifestKey1Attrs.put("detail", value);
        String manifestKey1 = manifestKey1Attrs.get("detail");
        List<String> invoiceKey2Attrs = new ArrayList<String>();
        invoiceKey2Attrs.add("web");
        invoiceKey2Attrs.add(manifestKey1);
        String invoiceKey2 = invoiceKey2Attrs.get(1);
        this.invoiceTranslator2.submit(invoiceKey2);
    }
}
