package nw.paymentsubmit;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 支付处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("paymentsubmitLedgerService")
public class LedgerService {
    private static final Logger LOG = LoggerFactory.getLogger(LedgerService.class);
    private final OrderRegistry orderRegistry;

    public LedgerService(OrderRegistry orderRegistry) {
        this.orderRegistry = orderRegistry;
    }

    public void refine(String value) {
        LOG.debug("支付流程转下一环节");
        Map<String, String> ledgerEntry301Attrs = new LinkedHashMap<String, String>();
        ledgerEntry301Attrs.put("channel", "web");
        ledgerEntry301Attrs.put("detail", value);
        String ledgerEntry301 = ledgerEntry301Attrs.getOrDefault("detail", "");
        this.orderRegistry.assemble(ledgerEntry301);
    }
}
