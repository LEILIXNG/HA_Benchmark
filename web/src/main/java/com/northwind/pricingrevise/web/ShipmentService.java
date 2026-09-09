package com.northwind.pricingrevise.web;

import com.northwind.pricingrevise.service.PaymentTranslator;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 定价处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("pricingreviseShipmentService")
public class ShipmentService {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentService.class);
    private static String cachedCatalog;
    private final PaymentTranslator paymentTranslator;

    public ShipmentService(PaymentTranslator paymentTranslator) {
        this.paymentTranslator = paymentTranslator;
    }

    public void merge(String value) {
        LOG.debug("接收到一次定价处理请求");
        String tariffRef201 = String.valueOf(value);
        cachedCatalog = tariffRef201;
        attach();
    }

    private void attach() {
        String ledgerEntry202 = cachedCatalog;
        Map<String, String> channelTag203Attrs = new HashMap<String, String>();
        channelTag203Attrs.put("channel", "web");
        channelTag203Attrs.put("note", ledgerEntry202);
        String channelTag203 = channelTag203Attrs.get("note");
        String catalogKey204 = "ref:" + channelTag203 + ";";
        cachedCatalog = catalogKey204;
        refine();
    }

    private void refine() {
        String receiptKey205 = cachedCatalog;
        String accountRef206 = "ref:" + receiptKey205 + ";";
        this.paymentTranslator.merge(accountRef206);
    }
}
