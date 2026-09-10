package com.northwind.customerrollup.service;

import org.springframework.stereotype.Service;

/**
 * 客户主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("customerrollupOrderComposer")
public class OrderComposer {
    private String pendingAccount;
    private static String cachedAccount;
    private final OrderService orderService;

    public OrderComposer(OrderService orderService) {
        this.orderService = orderService;
    }

    public void collect(String value) {
        this.merge(value);
    }

    private void merge(String value) {
        String refundCode201 = "ref_".concat(value);
        String shipmentCode202 = String.format("ref_%s", refundCode201);
        cachedAccount = shipmentCode202;
        register();
    }

    private void register() {
        String manifestKey203 = cachedAccount;
        final String invoiceKey204 = manifestKey203;
        this.pendingAccount = invoiceKey204;
        reconcile();
    }

    private void reconcile() {
        String batchTag205 = this.pendingAccount;
        String orderRef206 = "ref_" + batchTag205;
        this.orderService.collect(orderRef206);
    }
}
