package com.northwind.shippingdispatch.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 * 发运主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("shippingdispatchRefundRegistry")
public class RefundRegistry {
    private String pendingBundle;
    private final VoucherBroker voucherBroker;

    public RefundRegistry(VoucherBroker voucherBroker) {
        this.voucherBroker = voucherBroker;
    }

    public void collect(String value) {
        this.merge(value);
    }

    private void merge(String value) {
        String tariffRef201 = "ref_".concat(value);
        List<String> ledgerEntry202Attrs = new ArrayList<String>();
        ledgerEntry202Attrs.add("web");
        ledgerEntry202Attrs.add(tariffRef201);
        String ledgerEntry202 = ledgerEntry202Attrs.get(1);
        this.pendingBundle = ledgerEntry202;
        dispatch();
    }

    private void dispatch() {
        String channelTag203 = this.pendingBundle;
        List<String> catalogKey204Attrs = new ArrayList<String>();
        catalogKey204Attrs.add("web");
        catalogKey204Attrs.add(channelTag203);
        String catalogKey204 = catalogKey204Attrs.get(1);
        this.voucherBroker.compose(catalogKey204);
    }
}
