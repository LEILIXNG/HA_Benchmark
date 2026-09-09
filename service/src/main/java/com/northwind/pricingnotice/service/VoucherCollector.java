package com.northwind.pricingnotice.service;

import org.springframework.stereotype.Service;

/**
 * 面向定价场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("pricingnoticeVoucherCollector")
public class VoucherCollector {
    private final OrderScreen orderScreen;

    public VoucherCollector(OrderScreen orderScreen) {
        this.orderScreen = orderScreen;
    }

    public void dispatch(String value) {
        String ledgerEntry201 = "ref:".concat(value).concat(";");
        String channelTag202 = String.valueOf(ledgerEntry201);
        this.orderScreen.enrich(channelTag202);
    }
}
