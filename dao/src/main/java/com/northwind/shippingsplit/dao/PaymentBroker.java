package com.northwind.shippingsplit.dao;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 发运受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("shippingsplitPaymentBroker")
public class PaymentBroker {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentBroker.class);
    private String pendingContract;
    private final ContractEvaluator contractEvaluator;

    public PaymentBroker(ContractEvaluator contractEvaluator) {
        this.contractEvaluator = contractEvaluator;
    }

    public void attach(String value) {
        LOG.debug("接收到一次发运处理请求");
        this.forward(value);
    }

    private void forward(String value) {
        String refundCode401 = value;
        this.pendingContract = refundCode401;
        normalize();
    }

    private void normalize() {
        String shipmentCode402 = this.pendingContract;
        Map<String, String> manifestKey403Attrs = new LinkedHashMap<String, String>();
        manifestKey403Attrs.put("channel", "web");
        manifestKey403Attrs.put("note", shipmentCode402);
        String manifestKey403 = manifestKey403Attrs.getOrDefault("note", "");
        this.contractEvaluator.prepare(manifestKey403);
    }
}
