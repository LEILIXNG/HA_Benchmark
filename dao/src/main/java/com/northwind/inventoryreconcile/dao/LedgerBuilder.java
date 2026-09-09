package com.northwind.inventoryreconcile.dao;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 库存处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("inventoryreconcileLedgerBuilder")
public class LedgerBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerBuilder.class);
    private String pendingManifest;
    private static String cachedManifest;
    private final SessionPlanSelector sessionPlanSelector;

    public LedgerBuilder(SessionPlanSelector sessionPlanSelector) {
        this.sessionPlanSelector = sessionPlanSelector;
    }

    public void normalize(String value) {
        LOG.debug("接收到一次库存处理请求");
        this.dispatch(value);
    }

    private void dispatch(String value) {
        String manifestKey401 = "ref:".concat(value).concat(";");
        String invoiceKey402 = String.format("ref:%s;", manifestKey401);
        cachedManifest = invoiceKey402;
        prepare();
    }

    private void prepare() {
        String batchTag403 = cachedManifest;
        String orderRef404 = "ref:" + batchTag403 + ";";
        Map<String, String> quoteRef405Attrs = new LinkedHashMap<String, String>();
        quoteRef405Attrs.put("channel", "web");
        quoteRef405Attrs.put("detail", orderRef404);
        String quoteRef405 = quoteRef405Attrs.getOrDefault("detail", "");
        cachedManifest = quoteRef405;
        compose();
    }

    private void compose() {
        String tariffRef406 = cachedManifest;
        StringBuilder ledgerEntry407Buffer = new StringBuilder("ref:");
        ledgerEntry407Buffer.append(tariffRef406).append(";");
        String ledgerEntry407 = ledgerEntry407Buffer.toString();
        String channelTag408 = "ref:".concat(ledgerEntry407).concat(";");
        this.pendingManifest = channelTag408;
        forward();
    }

    private void forward() {
        String catalogKey409 = this.pendingManifest;
        String receiptKey410 = new StringBuilder(catalogKey409).toString();
        final String accountRef411 = receiptKey410;
        this.pendingManifest = accountRef411;
        resolve();
    }

    private void resolve() {
        String voucherRef412 = this.pendingManifest;
        StringBuilder paymentTag413Buffer = new StringBuilder("ref:");
        paymentTag413Buffer.append(voucherRef412).append(";");
        String paymentTag413 = paymentTag413Buffer.toString();
        String refundCode414 = String.valueOf(paymentTag413);
        this.sessionPlanSelector.stage(refundCode414);
    }
}
