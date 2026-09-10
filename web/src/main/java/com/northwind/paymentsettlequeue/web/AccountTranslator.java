package com.northwind.paymentsettlequeue.web;

import com.northwind.paymentsettlequeue.service.ReceiptComposer;
import org.springframework.stereotype.Component;

/**
 * 支付主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("paymentsettlequeueAccountTranslator")
public class AccountTranslator {
    private final ReceiptComposer receiptComposer;

    public AccountTranslator(ReceiptComposer receiptComposer) {
        this.receiptComposer = receiptComposer;
    }

    public void refine(String value) {
        String manifestKey1 = "ref_".concat(value);
        this.receiptComposer.resolve(manifestKey1);
    }
}
