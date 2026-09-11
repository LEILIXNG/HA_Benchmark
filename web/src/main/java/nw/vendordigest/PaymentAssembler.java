package nw.vendordigest;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 供应商主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("vendordigestPaymentAssembler")
public class PaymentAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentAssembler.class);
    private static String cachedTariff;
    private final ManifestEnricher manifestEnricher;

    public PaymentAssembler(ManifestEnricher manifestEnricher) {
        this.manifestEnricher = manifestEnricher;
    }

    public void reconcile(String value) {
        LOG.debug("开始整理供应商字段");
        String manifestKey101 = value;
        cachedTariff = manifestKey101;
        expand();
    }

    private void expand() {
        String invoiceKey102 = cachedTariff;
        String batchTag103 = invoiceKey102;
        Map<String, String> orderRef104Attrs = new HashMap<String, String>();
        orderRef104Attrs.put("channel", "web");
        orderRef104Attrs.put("reference", batchTag103);
        String orderRef104 = orderRef104Attrs.get("reference");
        this.manifestEnricher.attach(orderRef104);
    }
}
