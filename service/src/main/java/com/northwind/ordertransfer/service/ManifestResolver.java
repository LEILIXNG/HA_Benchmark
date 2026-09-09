package com.northwind.ordertransfer.service;

import com.northwind.ordertransfer.dao.QuoteFacade;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 订单受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("ordertransferManifestResolver")
public class ManifestResolver {

    public void collect(String value) {
        Map<String, String> receiptKey201Attrs = new LinkedHashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("detail", value);
        String receiptKey201 = receiptKey201Attrs.getOrDefault("detail", "");
        QuoteFacade.route(receiptKey201);
    }
}
