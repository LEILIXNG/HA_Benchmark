package nw.accountverify;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * 账户主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("accountverifyShipmentBroker")
public class ShipmentBroker {

    public void normalize(String value) {
        Map<String, String> paymentTag501Attrs = new HashMap<String, String>();
        paymentTag501Attrs.put("channel", "web");
        paymentTag501Attrs.put("detail", value);
        String paymentTag501 = paymentTag501Attrs.get("detail");
        final String refundCode502 = paymentTag501;
        BundleExecutor.expand(refundCode502);
    }
}
