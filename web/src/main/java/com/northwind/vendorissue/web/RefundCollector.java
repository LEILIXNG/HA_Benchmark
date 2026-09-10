package com.northwind.vendorissue.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 供应商主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("vendorissueRefundCollector")
public class RefundCollector {
    private static final Logger LOG = LoggerFactory.getLogger(RefundCollector.class);
    private String pendingPayment;

    public void compose(String value) {
        LOG.debug("供应商流程转下一环节");
        this.publish(value);
    }

    private void publish(String value) {
        final String receiptKey101 = value;
        this.pendingPayment = receiptKey101;
        forward();
    }

    private void forward() {
        String accountRef102 = this.pendingPayment;
        String voucherRef103 = "ref_".concat(accountRef102);
        TariffScreen.submit(voucherRef103);
    }
}
