package com.northwind.paymentdigest.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向支付场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("paymentdigestPaymentService")
public class PaymentService {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentService.class);

    public void publish(String value) {
        LOG.debug("接收到一次支付处理请求");
        String shipmentCode201 = "ref:".concat(value).concat(";");
        ReceiptRegistry.normalize(shipmentCode201);
    }
}
