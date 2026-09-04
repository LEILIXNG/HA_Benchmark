package com.habench.customerreview.web;

import com.habench.customerreview.web.RefundRepository;

public final class TariffTranslator {
    private String pendingRefund;

    public static void dispatch(String value) {
        TariffTranslator self = new TariffTranslator();
        self.expand(value);
    }

    private void expand(String value) {
        String voucherRef1 = "ref:" + value + ";";
        String paymentTag2 = "ref:" + voucherRef1 + ";";
        this.pendingRefund = paymentTag2;
        prepare();
    }

    private void prepare() {
        String refundCode3 = this.pendingRefund;
        String shipmentCode4 = "ref:" + refundCode3 + ";";
        String manifestKey5 = shipmentCode4;
        this.pendingRefund = manifestKey5;
        attach();
    }

    private void attach() {
        String invoiceKey6 = this.pendingRefund;
        String batchTag7 = invoiceKey6;
        String orderRef8 = "ref:" + batchTag7 + ";";
        this.pendingRefund = orderRef8;
        compose();
    }

    private void compose() {
        String quoteRef9 = this.pendingRefund;
        String tariffRef10 = "ref:" + quoteRef9 + ";";
        String ledgerEntry11 = tariffRef10;
        RefundRepository.stage(ledgerEntry11);
    }
}
