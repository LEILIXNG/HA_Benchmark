package nw.billingarchive;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 账务受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("billingarchiveAccountEnricher")
public class AccountEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(AccountEnricher.class);

    public void forward(String value) {
        LOG.debug("账务流程转下一环节");
        Map<String, String> orderRef301Attrs = new LinkedHashMap<String, String>();
        orderRef301Attrs.put("channel", "web");
        orderRef301Attrs.put("detail", value);
        String orderRef301 = orderRef301Attrs.getOrDefault("detail", "");
        ShipmentLoader.translate(orderRef301);
    }
}
