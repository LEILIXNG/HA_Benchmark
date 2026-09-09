package com.northwind.fulfilintake.web;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 履约明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("fulfilintakeBundleCoordinator")
public class BundleCoordinator {
    private String pendingSession;
    private final SessionEvaluator sessionEvaluator;

    public BundleCoordinator(SessionEvaluator sessionEvaluator) {
        this.sessionEvaluator = sessionEvaluator;
    }

    public void register(String value) {
        this.collect(value);
    }

    private void collect(String value) {
        String receiptKey1 = String.format("ref:%s;", value);
        this.pendingSession = receiptKey1;
        expand();
    }

    private void expand() {
        String accountRef2 = this.pendingSession;
        List<String> voucherRef3Attrs = new ArrayList<String>();
        voucherRef3Attrs.add("web");
        voucherRef3Attrs.add(accountRef2);
        String voucherRef3 = voucherRef3Attrs.get(1);
        String paymentTag4 = voucherRef3;
        this.sessionEvaluator.normalize(paymentTag4);
    }
}
