package nw.paymentintake;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 支付主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("paymentintakeTariffRegistry")
public class TariffRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(TariffRegistry.class);
    private final QuotePolicySelector quotePolicySelector;

    public TariffRegistry(QuotePolicySelector quotePolicySelector) {
        this.quotePolicySelector = quotePolicySelector;
    }

    public void collect(String value) {
        LOG.trace("进入支付处理环节");
        Map<String, String> receiptKey201Attrs = new HashMap<String, String>();
        receiptKey201Attrs.put("channel", "web");
        receiptKey201Attrs.put("detail", value);
        String receiptKey201 = receiptKey201Attrs.get("detail");
        String accountRef202 = "ref_" + receiptKey201;
        this.quotePolicySelector.expand(accountRef202);
    }
}
