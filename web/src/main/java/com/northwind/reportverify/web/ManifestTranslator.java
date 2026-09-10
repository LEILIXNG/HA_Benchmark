package com.northwind.reportverify.web;

import com.northwind.reportverify.service.PaymentNormalizer;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向报表场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("reportverifyManifestTranslator")
public class ManifestTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestTranslator.class);

    public void reconcile(String value) {
        LOG.debug("接收到一次报表处理请求");
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("detail", value);
        String shipmentCode1 = shipmentCode1Attrs.get("detail");
        StringBuilder manifestKey2Buffer = new StringBuilder("ref_");
        manifestKey2Buffer.append(shipmentCode1);
        String manifestKey2 = manifestKey2Buffer.toString();
        PaymentNormalizer.prepare(manifestKey2);
    }
}
