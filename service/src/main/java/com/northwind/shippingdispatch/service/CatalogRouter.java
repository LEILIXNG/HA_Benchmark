package com.northwind.shippingdispatch.service;

import com.northwind.shippingdispatch.dao.RefundRegistry;
import org.springframework.stereotype.Service;

/**
 * 发运受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("shippingdispatchCatalogRouter")
public class CatalogRouter {
    private final RefundRegistry refundRegistry;

    public CatalogRouter(RefundRegistry refundRegistry) {
        this.refundRegistry = refundRegistry;
    }

    public void assemble(String value) {
        String accountRef101 = value;
        this.refundRegistry.collect(accountRef101);
    }
}
