package com.northwind.catalogadjust.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 商品处理流程的中间环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("catalogadjustReceiptCollector")
public class ReceiptCollector {
    private final QuoteStrategySelector quoteStrategySelector;

    public ReceiptCollector(QuoteStrategySelector quoteStrategySelector) {
        this.quoteStrategySelector = quoteStrategySelector;
    }

    public void assemble(String value) {
        String paymentTag101 = value;
        Map<String, String> refundCode102Attrs = new LinkedHashMap<String, String>();
        refundCode102Attrs.put("channel", "web");
        refundCode102Attrs.put("remark", paymentTag101);
        String refundCode102 = refundCode102Attrs.getOrDefault("remark", "");
        this.quoteStrategySelector.dispatch(refundCode102);
    }
}
