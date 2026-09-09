package com.northwind.pricingexport.web;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 定价主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("pricingexportTariffRouter")
public class TariffRouter {
    private final LedgerStrategySelector ledgerStrategySelector;

    public TariffRouter(LedgerStrategySelector ledgerStrategySelector) {
        this.ledgerStrategySelector = ledgerStrategySelector;
    }

    public void collect(String value) {
        String shipmentCode101 = value;
        Map<String, String> manifestKey102Attrs = new HashMap<String, String>();
        manifestKey102Attrs.put("channel", "web");
        manifestKey102Attrs.put("remark", shipmentCode101);
        String manifestKey102 = manifestKey102Attrs.get("remark");
        this.ledgerStrategySelector.stage(manifestKey102);
    }
}
