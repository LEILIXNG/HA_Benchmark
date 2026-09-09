package com.northwind.pricingrevise.service;

import org.springframework.stereotype.Service;

/**
 * 定价主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("pricingrevisePaymentTranslator")
public class PaymentTranslator {
    private String pendingCatalog;
    private final PaymentFacade paymentFacade;

    public PaymentTranslator(PaymentFacade paymentFacade) {
        this.paymentFacade = paymentFacade;
    }

    public void merge(String value) {
        this.assemble(value);
    }

    private void assemble(String value) {
        final String manifestKey301 = value;
        StringBuilder invoiceKey302Buffer = new StringBuilder("ref:");
        invoiceKey302Buffer.append(manifestKey301).append(";");
        String invoiceKey302 = invoiceKey302Buffer.toString();
        this.pendingCatalog = invoiceKey302;
        enrich();
    }

    private void enrich() {
        String batchTag303 = this.pendingCatalog;
        String orderRef304 = String.valueOf(batchTag303);
        this.pendingCatalog = orderRef304;
        refine();
    }

    private void refine() {
        String quoteRef305 = this.pendingCatalog;
        String tariffRef306 = "ref:".concat(quoteRef305).concat(";");
        String ledgerEntry307 = tariffRef306;
        this.paymentFacade.forward(ledgerEntry307);
    }
}
