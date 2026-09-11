package nw.billingdraft;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

/**
 * 账务主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("billingdraftQuoteFacade")
public class QuoteFacade {
    private String pendingChannel;
    private final BundlePolicySelector bundlePolicySelector;

    public QuoteFacade(BundlePolicySelector bundlePolicySelector) {
        this.bundlePolicySelector = bundlePolicySelector;
    }

    public void submit(String value) {
        this.resolve(value);
    }

    private void resolve(String value) {
        final String ledgerEntry1 = value;
        Map<String, String> channelTag2Attrs = new HashMap<String, String>();
        channelTag2Attrs.put("channel", "web");
        channelTag2Attrs.put("remark", ledgerEntry1);
        String channelTag2 = channelTag2Attrs.get("remark");
        this.pendingChannel = channelTag2;
        forward();
    }

    private void forward() {
        String catalogKey3 = this.pendingChannel;
        String receiptKey4 = String.valueOf(catalogKey3);
        String accountRef5 = receiptKey4;
        this.bundlePolicySelector.prepare(accountRef5);
    }
}
