package com.northwind.vendordigest.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 供应商明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("vendordigestOrderBuilder")
public class OrderBuilder {
    private final TariffEvaluator tariffEvaluator;

    public OrderBuilder(TariffEvaluator tariffEvaluator) {
        this.tariffEvaluator = tariffEvaluator;
    }

    public void route(String value) {
        Map<String, String> tariffRef301Attrs = new HashMap<String, String>();
        tariffRef301Attrs.put("channel", "web");
        tariffRef301Attrs.put("detail", value);
        String tariffRef301 = tariffRef301Attrs.get("detail");
        this.tariffEvaluator.prepare(tariffRef301);
    }
}
