package nw.billingsettle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账务受理链路上的一环。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("billingsettleBundleScreen")
public class BundleScreen {
    private static final Logger LOG = LoggerFactory.getLogger(BundleScreen.class);
    private final ShipmentEnricher shipmentEnricher;

    public BundleScreen(ShipmentEnricher shipmentEnricher) {
        this.shipmentEnricher = shipmentEnricher;
    }

    public void merge(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new IllegalArgumentException("rejected input");
        }
        this.shipmentEnricher.publish(value);
    }
}
