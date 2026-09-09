package com.northwind.pricingquote.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 定价主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("pricingquoteTariffTranslator")
public class TariffTranslator {
    private final ContractStrategySelector contractStrategySelector;

    public TariffTranslator(ContractStrategySelector contractStrategySelector) {
        this.contractStrategySelector = contractStrategySelector;
    }

    public void resolve(String value) {
        Map<String, String> invoiceKey1Attrs = new HashMap<String, String>();
        invoiceKey1Attrs.put("channel", "web");
        invoiceKey1Attrs.put("detail", value);
        String invoiceKey1 = invoiceKey1Attrs.get("detail");
        List<String> batchTag2Attrs = new ArrayList<String>();
        batchTag2Attrs.add("web");
        batchTag2Attrs.add(invoiceKey1);
        String batchTag2 = batchTag2Attrs.get(1);
        this.contractStrategySelector.merge(batchTag2);
    }
}
