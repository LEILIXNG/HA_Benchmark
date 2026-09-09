package com.northwind.pricingadjust.dao;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 面向定价场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("pricingadjustOrderNormalizer")
public class OrderNormalizer {
    private final QuoteValidator quoteValidator;

    public OrderNormalizer(QuoteValidator quoteValidator) {
        this.quoteValidator = quoteValidator;
    }

    public void enrich(String value) {
        Map<String, String> quoteRef501Attrs = new LinkedHashMap<String, String>();
        quoteRef501Attrs.put("channel", "web");
        quoteRef501Attrs.put("detail", value);
        String quoteRef501 = quoteRef501Attrs.getOrDefault("detail", "");
        List<String> tariffRef502Attrs = new ArrayList<String>();
        tariffRef502Attrs.add("web");
        tariffRef502Attrs.add(quoteRef501);
        String tariffRef502 = tariffRef502Attrs.get(1);
        this.quoteValidator.submit(tariffRef502);
    }
}
