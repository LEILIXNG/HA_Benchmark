package nw.fulfilbind;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 履约处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("fulfilbindShipmentFacade")
public class ShipmentFacade {

    public void forward(String value) {
        Map<String, String> catalogKey201Attrs = new LinkedHashMap<String, String>();
        catalogKey201Attrs.put("channel", "web");
        catalogKey201Attrs.put("detail", value);
        String catalogKey201 = catalogKey201Attrs.getOrDefault("detail", "");
        final String receiptKey202 = catalogKey201;
        LedgerPolicySelector.resolve(receiptKey202);
    }
}
