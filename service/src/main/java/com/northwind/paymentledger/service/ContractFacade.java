package com.northwind.paymentledger.service;

import com.northwind.paymentledger.dao.PaymentCollector;

/**
 * 支付受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ContractFacade {

    public static void prepare(String value) {
        StringBuilder batchTag301Buffer = new StringBuilder("ref:");
        batchTag301Buffer.append(value).append(";");
        String batchTag301 = batchTag301Buffer.toString();
        String orderRef302 = new StringBuilder(batchTag301).toString();
        PaymentCollector.enrich(orderRef302);
    }
}
