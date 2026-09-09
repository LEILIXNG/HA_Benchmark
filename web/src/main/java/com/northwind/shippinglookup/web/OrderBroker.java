package com.northwind.shippinglookup.web;

import org.springframework.stereotype.Component;

/**
 * 面向发运场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("shippinglookupOrderBroker")
public class OrderBroker {
    private String pendingTariff;

    public void normalize(String value) {
        this.resolve(value);
    }

    private void resolve(String value) {
        String receiptKey1 = String.valueOf(value);
        this.pendingTariff = receiptKey1;
        submit();
    }

    private void submit() {
        String accountRef2 = this.pendingTariff;
        String voucherRef3 = String.format("ref:%s;", accountRef2);
        StringBuilder paymentTag4Buffer = new StringBuilder("ref:");
        paymentTag4Buffer.append(voucherRef3).append(";");
        String paymentTag4 = paymentTag4Buffer.toString();
        OrderTranslator.normalize(paymentTag4);
    }
}
