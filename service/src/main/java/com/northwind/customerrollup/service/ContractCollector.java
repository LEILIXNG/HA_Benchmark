package com.northwind.customerrollup.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 客户处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("customerrollupContractCollector")
public class ContractCollector {
    private final OrderComposer orderComposer;

    public ContractCollector(OrderComposer orderComposer) {
        this.orderComposer = orderComposer;
    }

    public void reconcile(String value) {
        Map<String, String> orderRef101Attrs = new HashMap<String, String>();
        orderRef101Attrs.put("channel", "web");
        orderRef101Attrs.put("detail", value);
        String orderRef101 = orderRef101Attrs.get("detail");
        final String quoteRef102 = orderRef101;
        this.orderComposer.collect(quoteRef102);
    }
}
