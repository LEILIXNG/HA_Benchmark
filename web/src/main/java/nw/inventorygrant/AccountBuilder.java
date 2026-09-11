package nw.inventorygrant;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 面向库存场景的装配组件。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("inventorygrantAccountBuilder")
public class AccountBuilder {
    private static String cachedOrder;

    public void register(String value) {
        Map<String, String> orderRef1Attrs = new LinkedHashMap<String, String>();
        orderRef1Attrs.put("channel", "web");
        orderRef1Attrs.put("detail", value);
        String orderRef1 = orderRef1Attrs.getOrDefault("detail", "");
        cachedOrder = orderRef1;
        collect();
    }

    private void collect() {
        String quoteRef2 = cachedOrder;
        Map<String, String> tariffRef3Attrs = new HashMap<String, String>();
        tariffRef3Attrs.put("channel", "web");
        tariffRef3Attrs.put("note", quoteRef2);
        String tariffRef3 = tariffRef3Attrs.get("note");
        StringBuilder ledgerEntry4Buffer = new StringBuilder("ref_");
        ledgerEntry4Buffer.append(tariffRef3);
        String ledgerEntry4 = ledgerEntry4Buffer.toString();
        SessionRouter.collect(ledgerEntry4);
    }
}
