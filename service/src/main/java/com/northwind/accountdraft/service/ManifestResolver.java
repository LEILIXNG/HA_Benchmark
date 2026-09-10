package com.northwind.accountdraft.service;

import org.springframework.stereotype.Service;

/**
 * 账户受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("accountdraftManifestResolver")
public class ManifestResolver {
    private final OrderBuilder orderBuilder;

    public ManifestResolver(OrderBuilder orderBuilder) {
        this.orderBuilder = orderBuilder;
    }

    public void register(String value) {
        String receiptKey201 = "ref_" + value;
        this.orderBuilder.reconcile(receiptKey201);
    }
}
