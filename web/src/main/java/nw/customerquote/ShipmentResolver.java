package nw.customerquote;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 客户明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("customerquoteShipmentResolver")
public class ShipmentResolver {
    private final AccountAdapter accountAdapter;

    public ShipmentResolver(AccountAdapter accountAdapter) {
        this.accountAdapter = accountAdapter;
    }

    public void stage(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("detail", value);
        String shipmentCode1 = shipmentCode1Attrs.get("detail");
        this.accountAdapter.route(shipmentCode1);
    }
}
