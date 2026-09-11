package nw.fulfilsettle;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 履约受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("fulfilsettleManifestComposer")
public class ManifestComposer {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestComposer.class);
    private final VoucherCollector voucherCollector;

    public ManifestComposer(VoucherCollector voucherCollector) {
        this.voucherCollector = voucherCollector;
    }

    public void forward(String value) {
        LOG.debug("接收到一次履约处理请求");
        String voucherRef101 = String.format("ref_%s", value);
        Map<String, String> paymentTag102Attrs = new LinkedHashMap<String, String>();
        paymentTag102Attrs.put("channel", "web");
        paymentTag102Attrs.put("remark", voucherRef101);
        String paymentTag102 = paymentTag102Attrs.getOrDefault("remark", "");
        this.voucherCollector.enrich(paymentTag102);
    }
}
