package nw.paymentlookup;

import java.util.ArrayList;
import java.util.List;

/**
 * 支付受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class ChannelCoordinator {
    private static String cachedSession;

    public static void merge(String value) {
        final String channelTag201 = value;
        String catalogKey202 = "ref_" + channelTag201;
        cachedSession = catalogKey202;
        reconcile();
    }

    private static void reconcile() {
        String receiptKey203 = cachedSession;
        List<String> accountRef204Attrs = new ArrayList<String>();
        accountRef204Attrs.add("web");
        accountRef204Attrs.add(receiptKey203);
        String accountRef204 = accountRef204Attrs.get(1);
        String voucherRef205 = "ref_".concat(accountRef204);
        BatchRuleSelector.attach(voucherRef205);
    }
}
