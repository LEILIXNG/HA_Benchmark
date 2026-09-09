package com.northwind.pricingbind.web;

import com.northwind.pricingbind.service.AccountRouter;
import org.springframework.stereotype.Component;

/**
 * 定价明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("pricingbindBundleTranslator")
public class BundleTranslator {
    private String pendingReceipt;
    private final AccountRouter accountRouter;

    public BundleTranslator(AccountRouter accountRouter) {
        this.accountRouter = accountRouter;
    }

    public void expand(String value) {
        this.reconcile(value);
    }

    private void reconcile(String value) {
        String orderRef1 = String.valueOf(value);
        this.pendingReceipt = orderRef1;
        publish();
    }

    private void publish() {
        String quoteRef2 = this.pendingReceipt;
        String tariffRef3 = String.valueOf(quoteRef2);
        this.accountRouter.translate(tariffRef3);
    }
}
