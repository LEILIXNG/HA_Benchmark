package nw.catalogtrace;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 商品处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("catalogtraceCatalogRouter")
public class CatalogRouter {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogRouter.class);
    private static String cachedShipment;
    private final TariffResolver tariffResolver;

    public CatalogRouter(TariffResolver tariffResolver) {
        this.tariffResolver = tariffResolver;
    }

    public void collect(String value) {
        LOG.debug("商品流程转下一环节");
        String paymentTag1 = String.valueOf(value);
        cachedShipment = paymentTag1;
        reconcile();
    }

    private void reconcile() {
        String refundCode2 = cachedShipment;
        Map<String, String> shipmentCode3Attrs = new LinkedHashMap<String, String>();
        shipmentCode3Attrs.put("channel", "web");
        shipmentCode3Attrs.put("note", refundCode2);
        String shipmentCode3 = shipmentCode3Attrs.getOrDefault("note", "");
        this.tariffResolver.refine(shipmentCode3);
    }
}
