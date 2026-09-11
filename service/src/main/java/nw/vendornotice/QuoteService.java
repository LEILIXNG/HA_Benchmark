package nw.vendornotice;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 供应商受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("vendornoticeQuoteService")
public class QuoteService {
    private static final Logger LOG = LoggerFactory.getLogger(QuoteService.class);
    private final BundleRuleSelector bundleRuleSelector;

    public QuoteService(BundleRuleSelector bundleRuleSelector) {
        this.bundleRuleSelector = bundleRuleSelector;
    }

    public void compose(String value) {
        LOG.debug("接收到一次供应商处理请求");
        Map<String, String> voucherRef201Attrs = new HashMap<String, String>();
        voucherRef201Attrs.put("channel", "web");
        voucherRef201Attrs.put("detail", value);
        String voucherRef201 = voucherRef201Attrs.get("detail");
        String paymentTag202 = String.valueOf(voucherRef201);
        this.bundleRuleSelector.merge(paymentTag202);
    }
}
