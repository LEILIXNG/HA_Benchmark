package nw.billingreopen;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 账务明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("billingreopenBundleCollector")
public class BundleCollector {
    private static final Logger LOG = LoggerFactory.getLogger(BundleCollector.class);
    private final VoucherRuleSelector voucherRuleSelector;

    public BundleCollector(VoucherRuleSelector voucherRuleSelector) {
        this.voucherRuleSelector = voucherRuleSelector;
    }

    public void enrich(String value) {
        LOG.trace("进入账务处理环节");
        Map<String, String> refundCode101Attrs = new HashMap<String, String>();
        refundCode101Attrs.put("channel", "web");
        refundCode101Attrs.put("detail", value);
        String refundCode101 = refundCode101Attrs.get("detail");
        String shipmentCode102 = String.valueOf(refundCode101);
        this.voucherRuleSelector.enrich(shipmentCode102);
    }
}
