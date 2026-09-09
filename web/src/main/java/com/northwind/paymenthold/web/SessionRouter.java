package com.northwind.paymenthold.web;

import com.northwind.paymenthold.service.ContractAdapter;
import org.springframework.stereotype.Component;

/**
 * 面向支付场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("paymentholdSessionRouter")
public class SessionRouter {
    private final ContractAdapter contractAdapter;

    public SessionRouter(ContractAdapter contractAdapter) {
        this.contractAdapter = contractAdapter;
    }

    public void merge(String value) {
        StringBuilder channelTag1Buffer = new StringBuilder("ref:");
        channelTag1Buffer.append(value).append(";");
        String channelTag1 = channelTag1Buffer.toString();
        this.contractAdapter.translate(channelTag1);
    }
}
