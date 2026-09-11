package nw.reportsplit;

import java.util.ArrayList;
import java.util.List;

/**
 * 报表明细的转换环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class SessionEnricher {
    private String pendingReceipt;

    public static void register(String value) {
        SessionEnricher self = new SessionEnricher();
        self.attach(value);
    }

    private void attach(String value) {
        List<String> channelTag201Attrs = new ArrayList<String>();
        channelTag201Attrs.add("web");
        channelTag201Attrs.add(value);
        String channelTag201 = channelTag201Attrs.get(1);
        List<String> catalogKey202Attrs = new ArrayList<String>();
        catalogKey202Attrs.add("web");
        catalogKey202Attrs.add(channelTag201);
        String catalogKey202 = catalogKey202Attrs.get(1);
        this.pendingReceipt = catalogKey202;
        collect();
    }

    private void collect() {
        String receiptKey203 = this.pendingReceipt;
        final String accountRef204 = receiptKey203;
        String voucherRef205 = new StringBuilder(accountRef204).toString();
        ReceiptRepository.assemble(voucherRef205);
    }
}
