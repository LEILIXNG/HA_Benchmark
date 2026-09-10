package com.northwind.fulfilexport.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 履约受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("fulfilexportTariffNormalizer")
public class TariffNormalizer {
    private String pendingBundle;
    private final QuotePlanSelector quotePlanSelector;

    public TariffNormalizer(QuotePlanSelector quotePlanSelector) {
        this.quotePlanSelector = quotePlanSelector;
    }

    public void translate(String value) {
        this.stage(value);
    }

    private void stage(String value) {
        String shipmentCode1 = "ref_" + value;
        Map<String, String> manifestKey2Attrs = new LinkedHashMap<String, String>();
        manifestKey2Attrs.put("channel", "web");
        manifestKey2Attrs.put("remark", shipmentCode1);
        String manifestKey2 = manifestKey2Attrs.getOrDefault("remark", "");
        this.pendingBundle = manifestKey2;
        submit();
    }

    private void submit() {
        String invoiceKey3 = this.pendingBundle;
        String batchTag4 = invoiceKey3;
        this.quotePlanSelector.expand(batchTag4);
    }
}
