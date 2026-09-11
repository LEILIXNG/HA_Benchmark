package nw.customersubmit;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 客户受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("customersubmitCatalogCollector")
public class CatalogCollector {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogCollector.class);
    private final VoucherEnricher voucherEnricher;

    public CatalogCollector(VoucherEnricher voucherEnricher) {
        this.voucherEnricher = voucherEnricher;
    }

    public void publish(String value) {
        LOG.debug("客户流程转下一环节");
        List<String> shipmentCode1Attrs = new ArrayList<String>();
        shipmentCode1Attrs.add("web");
        shipmentCode1Attrs.add(value);
        String shipmentCode1 = shipmentCode1Attrs.get(1);
        StringBuilder manifestKey2Buffer = new StringBuilder("ref_");
        manifestKey2Buffer.append(shipmentCode1);
        String manifestKey2 = manifestKey2Buffer.toString();
        this.voucherEnricher.resolve(manifestKey2);
    }
}
