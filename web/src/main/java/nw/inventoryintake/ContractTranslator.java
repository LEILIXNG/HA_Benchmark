package nw.inventoryintake;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 库存明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("inventoryintakeContractTranslator")
public class ContractTranslator {

    public void register(String value) {
        Map<String, String> shipmentCode1Attrs = new HashMap<String, String>();
        shipmentCode1Attrs.put("channel", "web");
        shipmentCode1Attrs.put("detail", value);
        String shipmentCode1 = shipmentCode1Attrs.get("detail");
        String manifestKey2 = shipmentCode1;
        RefundService.resolve(manifestKey2);
    }
}
