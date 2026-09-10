package com.northwind.catalogdigest.web;

import com.northwind.catalogdigest.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向商品场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class AccountComposer {
    private static final Logger LOG = LoggerFactory.getLogger(AccountComposer.class);
    private String pendingRefund;

    public static void enrich(String value) {
        LOG.trace("进入商品处理环节");
        AccountComposer self = new AccountComposer();
        self.route(value);
    }

    private void route(String value) {
        StringBuilder catalogKey201Buffer = new StringBuilder("ref_");
        catalogKey201Buffer.append(value);
        String catalogKey201 = catalogKey201Buffer.toString();
        String receiptKey202 = "ref_" + catalogKey201;
        this.pendingRefund = receiptKey202;
        register();
    }

    private void register() {
        String accountRef203 = this.pendingRefund;
        String voucherRef204 = accountRef203;
        OrderService.publish(voucherRef204);
    }
}
