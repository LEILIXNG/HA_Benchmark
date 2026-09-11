package nw.fulfilcapture;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 履约受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("fulfilcaptureTariffAssembler")
public class TariffAssembler {
    private static final Logger LOG = LoggerFactory.getLogger(TariffAssembler.class);

    public void attach(String value) {
        LOG.trace("进入履约处理环节");
        String receiptKey101 = String.format("ref_%s", value);
        Map<String, String> accountRef102Attrs = new HashMap<String, String>();
        accountRef102Attrs.put("channel", "web");
        accountRef102Attrs.put("remark", receiptKey101);
        String accountRef102 = accountRef102Attrs.get("remark");
        SessionCoordinator.publish(accountRef102);
    }
}
