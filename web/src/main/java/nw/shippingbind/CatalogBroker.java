package nw.shippingbind;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 发运明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("shippingbindCatalogBroker")
public class CatalogBroker {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogBroker.class);
    private static String cachedOrder;
    private final SessionRouter sessionRouter;

    public CatalogBroker(SessionRouter sessionRouter) {
        this.sessionRouter = sessionRouter;
    }

    public void assemble(String value) {
        LOG.debug("发运流程转下一环节");
        final String quoteRef101 = value;
        cachedOrder = quoteRef101;
        normalize();
    }

    private void normalize() {
        String tariffRef102 = cachedOrder;
        final String ledgerEntry103 = tariffRef102;
        cachedOrder = ledgerEntry103;
        collect();
    }

    private void collect() {
        String channelTag104 = cachedOrder;
        String catalogKey105 = channelTag104;
        Map<String, String> receiptKey106Attrs = new HashMap<String, String>();
        receiptKey106Attrs.put("channel", "web");
        receiptKey106Attrs.put("remark", catalogKey105);
        String receiptKey106 = receiptKey106Attrs.get("remark");
        cachedOrder = receiptKey106;
        prepare();
    }

    private void prepare() {
        String accountRef107 = cachedOrder;
        Map<String, String> voucherRef108Attrs = new LinkedHashMap<String, String>();
        voucherRef108Attrs.put("channel", "web");
        voucherRef108Attrs.put("reference", accountRef107);
        String voucherRef108 = voucherRef108Attrs.getOrDefault("reference", "");
        this.sessionRouter.dispatch(voucherRef108);
    }
}
