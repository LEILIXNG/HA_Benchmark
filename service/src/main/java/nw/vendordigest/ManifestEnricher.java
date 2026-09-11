package nw.vendordigest;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("vendordigestManifestEnricher")
public class ManifestEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestEnricher.class);
    private String pendingTariff;
    private static String cachedTariff;
    private final BatchStrategySelector batchStrategySelector;

    public ManifestEnricher(BatchStrategySelector batchStrategySelector) {
        this.batchStrategySelector = batchStrategySelector;
    }

    public void attach(String value) {
        LOG.debug("开始整理供应商字段");
        this.enrich(value);
    }

    private void enrich(String value) {
        Map<String, String> accountRef201Attrs = new LinkedHashMap<String, String>();
        accountRef201Attrs.put("channel", "web");
        accountRef201Attrs.put("detail", value);
        String accountRef201 = accountRef201Attrs.getOrDefault("detail", "");
        cachedTariff = accountRef201;
        publish();
    }

    private void publish() {
        String voucherRef202 = cachedTariff;
        final String paymentTag203 = voucherRef202;
        this.pendingTariff = paymentTag203;
        route();
    }

    private void route() {
        String refundCode204 = this.pendingTariff;
        List<String> shipmentCode205Attrs = new ArrayList<String>();
        shipmentCode205Attrs.add("web");
        shipmentCode205Attrs.add(refundCode204);
        String shipmentCode205 = shipmentCode205Attrs.get(1);
        this.pendingTariff = shipmentCode205;
        compose();
    }

    private void compose() {
        String manifestKey206 = this.pendingTariff;
        String invoiceKey207 = manifestKey206;
        Map<String, String> batchTag208Attrs = new LinkedHashMap<String, String>();
        batchTag208Attrs.put("channel", "web");
        batchTag208Attrs.put("reference", invoiceKey207);
        String batchTag208 = batchTag208Attrs.getOrDefault("reference", "");
        this.batchStrategySelector.normalize(batchTag208);
    }
}
