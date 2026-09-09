package com.northwind.inventoryarchive.service;

import com.northwind.inventoryarchive.dao.TariffAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 面向库存场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("inventoryarchiveQuoteComposer")
public class QuoteComposer {
    private final TariffAdapter tariffAdapter;

    public QuoteComposer(TariffAdapter tariffAdapter) {
        this.tariffAdapter = tariffAdapter;
    }

    public void forward(String value) {
        Map<String, String> paymentTag101Attrs = new LinkedHashMap<String, String>();
        paymentTag101Attrs.put("channel", "web");
        paymentTag101Attrs.put("detail", value);
        String paymentTag101 = paymentTag101Attrs.getOrDefault("detail", "");
        String refundCode102 = String.valueOf(paymentTag101);
        this.tariffAdapter.dispatch(refundCode102);
    }
}
