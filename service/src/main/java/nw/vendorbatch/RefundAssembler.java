package nw.vendorbatch;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 供应商明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Service("vendorbatchRefundAssembler")
public class RefundAssembler {
    private String pendingLedger;
    private final ChannelRuleSelector channelRuleSelector;

    public RefundAssembler(ChannelRuleSelector channelRuleSelector) {
        this.channelRuleSelector = channelRuleSelector;
    }

    public void forward(String value) {
        this.normalize(value);
    }

    private void normalize(String value) {
        Map<String, String> channelTag101Attrs = new LinkedHashMap<String, String>();
        channelTag101Attrs.put("channel", "web");
        channelTag101Attrs.put("detail", value);
        String channelTag101 = channelTag101Attrs.getOrDefault("detail", "");
        this.pendingLedger = channelTag101;
        prepare();
    }

    private void prepare() {
        String catalogKey102 = this.pendingLedger;
        String receiptKey103 = String.valueOf(catalogKey102);
        this.pendingLedger = receiptKey103;
        route();
    }

    private void route() {
        String accountRef104 = this.pendingLedger;
        Map<String, String> voucherRef105Attrs = new HashMap<String, String>();
        voucherRef105Attrs.put("channel", "web");
        voucherRef105Attrs.put("detail", accountRef104);
        String voucherRef105 = voucherRef105Attrs.get("detail");
        final String paymentTag106 = voucherRef105;
        this.channelRuleSelector.resolve(paymentTag106);
    }
}
