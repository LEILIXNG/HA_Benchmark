package com.northwind.vendorquote.web;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 供应商明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("vendorquoteVoucherBuilder")
public class VoucherBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherBuilder.class);
    private String pendingQuote;
    private static String cachedQuote;
    private final BatchValidator batchValidator;

    public VoucherBuilder(BatchValidator batchValidator) {
        this.batchValidator = batchValidator;
    }

    public void submit(String value) {
        LOG.trace("进入供应商处理环节");
        this.publish(value);
    }

    private void publish(String value) {
        List<String> refundCode1Attrs = new ArrayList<String>();
        refundCode1Attrs.add("web");
        refundCode1Attrs.add(value);
        String refundCode1 = refundCode1Attrs.get(1);
        this.pendingQuote = refundCode1;
        reconcile();
    }

    private void reconcile() {
        String shipmentCode2 = this.pendingQuote;
        String manifestKey3 = String.format("ref_%s", shipmentCode2);
        this.pendingQuote = manifestKey3;
        route();
    }

    private void route() {
        String invoiceKey4 = this.pendingQuote;
        final String batchTag5 = invoiceKey4;
        cachedQuote = batchTag5;
        translate();
    }

    private void translate() {
        String orderRef6 = cachedQuote;
        final String quoteRef7 = orderRef6;
        cachedQuote = quoteRef7;
        enrich();
    }

    private void enrich() {
        String tariffRef8 = cachedQuote;
        String ledgerEntry9 = String.valueOf(tariffRef8);
        String channelTag10 = "ref_".concat(ledgerEntry9);
        this.pendingQuote = channelTag10;
        dispatch();
    }

    private void dispatch() {
        String catalogKey11 = this.pendingQuote;
        String receiptKey12 = String.valueOf(catalogKey11);
        this.batchValidator.refine(receiptKey12);
    }
}
