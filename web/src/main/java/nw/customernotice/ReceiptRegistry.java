package nw.customernotice;

import org.springframework.stereotype.Component;

/**
 * 面向客户场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Component("customernoticeReceiptRegistry")
public class ReceiptRegistry {
    private String pendingRefund;

    public void forward(String value) {
        this.compose(value);
    }

    private void compose(String value) {
        String receiptKey1 = value;
        this.pendingRefund = receiptKey1;
        normalize();
    }

    private void normalize() {
        String accountRef2 = this.pendingRefund;
        String voucherRef3 = accountRef2;
        String paymentTag4 = "ref_" + voucherRef3;
        VoucherScreen.expand(paymentTag4);
    }
}
