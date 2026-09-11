package nw.fulfilreview;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 履约处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class RefundAssembler {
    private String pendingVoucher;
    private static String cachedVoucher;

    public static void route(String value) {
        RefundAssembler self = new RefundAssembler();
        self.attach(value);
    }

    private void attach(String value) {
        String channelTag301 = String.valueOf(value);
        cachedVoucher = channelTag301;
        submit();
    }

    private void submit() {
        String catalogKey302 = cachedVoucher;
        Map<String, String> receiptKey303Attrs = new LinkedHashMap<String, String>();
        receiptKey303Attrs.put("channel", "web");
        receiptKey303Attrs.put("note", catalogKey302);
        String receiptKey303 = receiptKey303Attrs.getOrDefault("note", "");
        this.pendingVoucher = receiptKey303;
        prepare();
    }

    private void prepare() {
        String accountRef304 = this.pendingVoucher;
        String voucherRef305 = "ref_" + accountRef304;
        StringBuilder paymentTag306Buffer = new StringBuilder("ref_");
        paymentTag306Buffer.append(voucherRef305);
        String paymentTag306 = paymentTag306Buffer.toString();
        VoucherExecutor.collect(paymentTag306);
    }
}
