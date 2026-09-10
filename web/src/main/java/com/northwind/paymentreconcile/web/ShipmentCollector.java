package com.northwind.paymentreconcile.web;

import com.northwind.paymentreconcile.service.VoucherAdapter;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 支付处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("paymentreconcileShipmentCollector")
public class ShipmentCollector {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentCollector.class);
    private String pendingManifest;
    private static String cachedManifest;
    private final VoucherAdapter voucherAdapter;

    public ShipmentCollector(VoucherAdapter voucherAdapter) {
        this.voucherAdapter = voucherAdapter;
    }

    public void register(String value) {
        LOG.trace("进入支付处理环节");
        this.route(value);
    }

    private void route(String value) {
        String ledgerEntry1 = String.valueOf(value);
        this.pendingManifest = ledgerEntry1;
        compose();
    }

    private void compose() {
        String channelTag2 = this.pendingManifest;
        String catalogKey3 = "ref_".concat(channelTag2);
        List<String> receiptKey4Attrs = new ArrayList<String>();
        receiptKey4Attrs.add("web");
        receiptKey4Attrs.add(catalogKey3);
        String receiptKey4 = receiptKey4Attrs.get(1);
        cachedManifest = receiptKey4;
        normalize();
    }

    private void normalize() {
        String accountRef5 = cachedManifest;
        String voucherRef6 = "ref_" + accountRef5;
        cachedManifest = voucherRef6;
        reconcile();
    }

    private void reconcile() {
        String paymentTag7 = cachedManifest;
        String refundCode8 = "ref_".concat(paymentTag7);
        this.voucherAdapter.submit(refundCode8);
    }
}
