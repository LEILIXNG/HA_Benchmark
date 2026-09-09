package com.northwind.orderrelease.dao;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 订单明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("orderreleaseAccountAdapter")
public class AccountAdapter {
    private String pendingCatalog;
    private static String cachedCatalog;
    private final QuoteNormalizer quoteNormalizer;

    public AccountAdapter(QuoteNormalizer quoteNormalizer) {
        this.quoteNormalizer = quoteNormalizer;
    }

    public void dispatch(String value) {
        this.collect(value);
    }

    private void collect(String value) {
        StringBuilder batchTag401Buffer = new StringBuilder("ref:");
        batchTag401Buffer.append(value).append(";");
        String batchTag401 = batchTag401Buffer.toString();
        cachedCatalog = batchTag401;
        expand();
    }

    private void expand() {
        String orderRef402 = cachedCatalog;
        final String quoteRef403 = orderRef402;
        String tariffRef404 = String.format("ref:%s;", quoteRef403);
        this.pendingCatalog = tariffRef404;
        forward();
    }

    private void forward() {
        String ledgerEntry405 = this.pendingCatalog;
        String channelTag406 = String.valueOf(ledgerEntry405);
        String catalogKey407 = "ref:".concat(channelTag406).concat(";");
        this.pendingCatalog = catalogKey407;
        submit();
    }

    private void submit() {
        String receiptKey408 = this.pendingCatalog;
        Map<String, String> accountRef409Attrs = new HashMap<String, String>();
        accountRef409Attrs.put("channel", "web");
        accountRef409Attrs.put("detail", receiptKey408);
        String accountRef409 = accountRef409Attrs.get("detail");
        String voucherRef410 = String.format("ref:%s;", accountRef409);
        this.pendingCatalog = voucherRef410;
        stage();
    }

    private void stage() {
        String paymentTag411 = this.pendingCatalog;
        String refundCode412 = String.valueOf(paymentTag411);
        this.quoteNormalizer.assemble(refundCode412);
    }
}
