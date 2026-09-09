package com.northwind.billinghold.service;

import org.springframework.stereotype.Service;

/**
 * 账务受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Service("billingholdPaymentNormalizer")
public class PaymentNormalizer {
    private static String cachedReceipt;
    private final BatchPolicySelector batchPolicySelector;

    public PaymentNormalizer(BatchPolicySelector batchPolicySelector) {
        this.batchPolicySelector = batchPolicySelector;
    }

    public void compose(String value) {
        String accountRef401 = "ref:" + value + ";";
        String voucherRef402 = new StringBuilder(accountRef401).toString();
        cachedReceipt = voucherRef402;
        translate();
    }

    private void translate() {
        String paymentTag403 = cachedReceipt;
        String refundCode404 = String.valueOf(paymentTag403);
        this.batchPolicySelector.dispatch(refundCode404);
    }
}
