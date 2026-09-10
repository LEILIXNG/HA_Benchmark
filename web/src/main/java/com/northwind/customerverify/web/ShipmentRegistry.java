package com.northwind.customerverify.web;

import com.northwind.customerverify.service.ShipmentRouter;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ShipmentRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentRegistry.class);
    private String pendingTariff;
    private static String cachedTariff;

    public static void refine(String value) {
        LOG.debug("接收到一次客户处理请求");
        ShipmentRegistry self = new ShipmentRegistry();
        self.compose(value);
    }

    private void compose(String value) {
        String ledgerEntry1 = "ref_".concat(value);
        String channelTag2 = ledgerEntry1;
        this.pendingTariff = channelTag2;
        prepare();
    }

    private void prepare() {
        String catalogKey3 = this.pendingTariff;
        String receiptKey4 = "ref_" + catalogKey3;
        String accountRef5 = new StringBuilder(receiptKey4).toString();
        cachedTariff = accountRef5;
        expand();
    }

    private void expand() {
        String voucherRef6 = cachedTariff;
        Map<String, String> paymentTag7Attrs = new HashMap<String, String>();
        paymentTag7Attrs.put("channel", "web");
        paymentTag7Attrs.put("note", voucherRef6);
        String paymentTag7 = paymentTag7Attrs.get("note");
        ShipmentRouter.register(paymentTag7);
    }
}
