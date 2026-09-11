package nw.customercapture;

import org.springframework.stereotype.Repository;

/**
 * 面向客户场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("customercaptureReceiptNormalizer")
public class ReceiptNormalizer {
    private String pendingRefund;
    private final RefundLoader refundLoader;

    public ReceiptNormalizer(RefundLoader refundLoader) {
        this.refundLoader = refundLoader;
    }

    public void attach(String value) {
        this.prepare(value);
    }

    private void prepare(String value) {
        StringBuilder voucherRef401Buffer = new StringBuilder("ref_");
        voucherRef401Buffer.append(value);
        String voucherRef401 = voucherRef401Buffer.toString();
        this.pendingRefund = voucherRef401;
        publish();
    }

    private void publish() {
        String paymentTag402 = this.pendingRefund;
        String refundCode403 = new StringBuilder(paymentTag402).toString();
        this.refundLoader.enrich(refundCode403);
    }
}
