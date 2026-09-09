package com.northwind.customergrant.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向客户场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class SessionRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(SessionRegistry.class);
    private static String cachedShipment;

    public static void forward(String value) {
        LOG.debug("接收到一次客户处理请求");
        List<String> tariffRef301Attrs = new ArrayList<String>();
        tariffRef301Attrs.add("web");
        tariffRef301Attrs.add(value);
        String tariffRef301 = tariffRef301Attrs.get(1);
        cachedShipment = tariffRef301;
        stage();
    }

    private static void stage() {
        String ledgerEntry302 = cachedShipment;
        String channelTag303 = "ref:" + ledgerEntry302 + ";";
        cachedShipment = channelTag303;
        resolve();
    }

    private static void resolve() {
        String catalogKey304 = cachedShipment;
        String receiptKey305 = String.format("ref:%s;", catalogKey304);
        String accountRef306 = String.valueOf(receiptKey305);
        cachedShipment = accountRef306;
        refine();
    }

    private static void refine() {
        String voucherRef307 = cachedShipment;
        Map<String, String> paymentTag308Attrs = new LinkedHashMap<String, String>();
        paymentTag308Attrs.put("channel", "web");
        paymentTag308Attrs.put("reference", voucherRef307);
        String paymentTag308 = paymentTag308Attrs.getOrDefault("reference", "");
        String refundCode309 = new StringBuilder(paymentTag308).toString();
        ShipmentGateway.reconcile(refundCode309);
    }
}
