package com.northwind.paymentintake.service;

import com.northwind.paymentintake.dao.TariffRegistry;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向支付场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("paymentintakeQuoteAdapter")
public class QuoteAdapter {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteAdapter.class);
    private static String cachedVoucher;
    private final TariffRegistry tariffRegistry;

    public QuoteAdapter(TariffRegistry tariffRegistry) {
        this.tariffRegistry = tariffRegistry;
    }

    public void stage(String value) {
        LOG.trace("进入支付处理环节");
        String shipmentCode101 = new StringBuilder(value).toString();
        String manifestKey102 = String.format("ref_%s", shipmentCode101);
        cachedVoucher = manifestKey102;
        dispatch();
    }

    private void dispatch() {
        String invoiceKey103 = cachedVoucher;
        String batchTag104 = invoiceKey103;
        Map<String, String> orderRef105Attrs = new LinkedHashMap<String, String>();
        orderRef105Attrs.put("channel", "web");
        orderRef105Attrs.put("detail", batchTag104);
        String orderRef105 = orderRef105Attrs.getOrDefault("detail", "");
        this.tariffRegistry.collect(orderRef105);
    }
}
