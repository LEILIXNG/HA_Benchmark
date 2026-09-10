package com.northwind.customerdraft.service;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 客户明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("customerdraftAccountBroker")
public class AccountBroker {
    private static String cachedShipment;
    private final OrderComposer orderComposer;

    public AccountBroker(OrderComposer orderComposer) {
        this.orderComposer = orderComposer;
    }

    public void route(String value) {
        Map<String, String> orderRef301Attrs = new LinkedHashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("detail", value);
        String orderRef301 = orderRef301Attrs.getOrDefault("detail", "");
        StringBuilder quoteRef302Buffer = new StringBuilder("ref_");
        quoteRef302Buffer.append(orderRef301);
        String quoteRef302 = quoteRef302Buffer.toString();
        cachedShipment = quoteRef302;
        submit();
    }

    private void submit() {
        String tariffRef303 = cachedShipment;
        String ledgerEntry304 = tariffRef303;
        String channelTag305 = String.valueOf(ledgerEntry304);
        this.orderComposer.refine(channelTag305);
    }
}
