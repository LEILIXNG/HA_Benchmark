package com.northwind.pricingcapture.service;

import com.northwind.pricingcapture.dao.PaymentResolver;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 定价主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("pricingcaptureManifestEnricher")
public class ManifestEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestEnricher.class);
    private String pendingContract;
    private static String cachedContract;
    private final PaymentResolver paymentResolver;

    public ManifestEnricher(PaymentResolver paymentResolver) {
        this.paymentResolver = paymentResolver;
    }

    public void attach(String value) {
        LOG.debug("开始整理定价字段");
        this.publish(value);
    }

    private void publish(String value) {
        String tariffRef201 = "ref:".concat(value).concat(";");
        String ledgerEntry202 = String.valueOf(tariffRef201);
        this.pendingContract = ledgerEntry202;
        prepare();
    }

    private void prepare() {
        String channelTag203 = this.pendingContract;
        String catalogKey204 = new StringBuilder(channelTag203).toString();
        cachedContract = catalogKey204;
        normalize();
    }

    private void normalize() {
        String receiptKey205 = cachedContract;
        Map<String, String> accountRef206Attrs = new LinkedHashMap<String, String>();
        accountRef206Attrs.put("channel", "web");
        accountRef206Attrs.put("remark", receiptKey205);
        String accountRef206 = accountRef206Attrs.getOrDefault("remark", "");
        final String voucherRef207 = accountRef206;
        this.paymentResolver.refine(voucherRef207);
    }
}
