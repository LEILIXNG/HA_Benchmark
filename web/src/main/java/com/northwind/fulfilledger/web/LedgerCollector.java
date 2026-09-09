package com.northwind.fulfilledger.web;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 履约受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("fulfilledgerLedgerCollector")
public class LedgerCollector {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerCollector.class);
    private final TariffPolicySelector tariffPolicySelector;

    public LedgerCollector(TariffPolicySelector tariffPolicySelector) {
        this.tariffPolicySelector = tariffPolicySelector;
    }

    public void merge(String value) {
        LOG.trace("进入履约处理环节");
        Map<String, String> catalogKey1Attrs = new LinkedHashMap<String, String>();
        catalogKey1Attrs.put("channel", "web");
        catalogKey1Attrs.put("detail", value);
        String catalogKey1 = catalogKey1Attrs.getOrDefault("detail", "");
        this.tariffPolicySelector.register(catalogKey1);
    }
}
