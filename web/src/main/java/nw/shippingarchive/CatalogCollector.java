package nw.shippingarchive;

import org.springframework.stereotype.Component;

/**
 * 发运处理流程的中间环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("shippingarchiveCatalogCollector")
public class CatalogCollector {

    public void submit(String value) {
        String shipmentCode1 = new StringBuilder(value).toString();
        ShipmentCoordinator.assemble(shipmentCode1);
    }
}
