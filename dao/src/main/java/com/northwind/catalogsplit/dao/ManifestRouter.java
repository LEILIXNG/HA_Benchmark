package com.northwind.catalogsplit.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 商品明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("catalogsplitManifestRouter")
public class ManifestRouter {
    private String pendingAccount;
    private static String cachedAccount;

    public void merge(String value) {
        this.enrich(value);
    }

    private void enrich(String value) {
        StringBuilder quoteRef401Buffer = new StringBuilder("ref_");
        quoteRef401Buffer.append(value);
        String quoteRef401 = quoteRef401Buffer.toString();
        String tariffRef402 = "ref_" + quoteRef401;
        cachedAccount = tariffRef402;
        submit();
    }

    private void submit() {
        String ledgerEntry403 = cachedAccount;
        String channelTag404 = String.format("ref_%s", ledgerEntry403);
        Map<String, String> catalogKey405Attrs = new HashMap<String, String>();
        catalogKey405Attrs.put("channel", "web");
        catalogKey405Attrs.put("detail", channelTag404);
        String catalogKey405 = catalogKey405Attrs.get("detail");
        cachedAccount = catalogKey405;
        route();
    }

    private void route() {
        String receiptKey406 = cachedAccount;
        String accountRef407 = "ref_".concat(receiptKey406);
        StringBuilder voucherRef408Buffer = new StringBuilder("ref_");
        voucherRef408Buffer.append(accountRef407);
        String voucherRef408 = voucherRef408Buffer.toString();
        this.pendingAccount = voucherRef408;
        attach();
    }

    private void attach() {
        String paymentTag409 = this.pendingAccount;
        final String refundCode410 = paymentTag409;
        String shipmentCode411 = new StringBuilder(refundCode410).toString();
        this.pendingAccount = shipmentCode411;
        prepare();
    }

    private void prepare() {
        String manifestKey412 = this.pendingAccount;
        String invoiceKey413 = "ref_".concat(manifestKey412);
        String batchTag414 = invoiceKey413;
        ShipmentRuleSelector.forward(batchTag414);
    }
}
