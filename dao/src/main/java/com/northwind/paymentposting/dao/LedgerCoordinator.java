package com.northwind.paymentposting.dao;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class LedgerCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerCoordinator.class);
    private static String cachedSession;

    public static void route(String value) {
        LOG.debug("支付流程转下一环节");
        String accountRef401 = "ref_" + value;
        String voucherRef402 = String.valueOf(accountRef401);
        cachedSession = voucherRef402;
        compose();
    }

    private static void compose() {
        String paymentTag403 = cachedSession;
        Map<String, String> refundCode404Attrs = new HashMap<String, String>();
        refundCode404Attrs.put("channel", "web");
        refundCode404Attrs.put("reference", paymentTag403);
        String refundCode404 = refundCode404Attrs.get("reference");
        CatalogAdapter.reconcile(refundCode404);
    }
}
