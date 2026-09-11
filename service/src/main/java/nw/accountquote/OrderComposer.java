package nw.accountquote;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 * 账户明细的转换环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Service("accountquoteOrderComposer")
public class OrderComposer {
    private String pendingBatch;
    private final RefundValidator refundValidator;

    public OrderComposer(RefundValidator refundValidator) {
        this.refundValidator = refundValidator;
    }

    public void merge(String value) {
        this.stage(value);
    }

    private void stage(String value) {
        List<String> channelTag201Attrs = new ArrayList<String>();
        channelTag201Attrs.add("web");
        channelTag201Attrs.add(value);
        String channelTag201 = channelTag201Attrs.get(1);
        List<String> catalogKey202Attrs = new ArrayList<String>();
        catalogKey202Attrs.add("web");
        catalogKey202Attrs.add(channelTag201);
        String catalogKey202 = catalogKey202Attrs.get(1);
        this.pendingBatch = catalogKey202;
        attach();
    }

    private void attach() {
        String receiptKey203 = this.pendingBatch;
        String accountRef204 = String.valueOf(receiptKey203);
        Map<String, String> voucherRef205Attrs = new LinkedHashMap<String, String>();
        voucherRef205Attrs.put("channel", "web");
        voucherRef205Attrs.put("detail", accountRef204);
        String voucherRef205 = voucherRef205Attrs.getOrDefault("detail", "");
        this.refundValidator.collect(voucherRef205);
    }
}
