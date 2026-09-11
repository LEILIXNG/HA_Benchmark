package nw.accountreconcile;

import org.springframework.stereotype.Service;

/**
 * 账户受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("accountreconcileSessionTranslator")
public class SessionTranslator {
    private String pendingBundle;
    private final RefundEnricher refundEnricher;

    public SessionTranslator(RefundEnricher refundEnricher) {
        this.refundEnricher = refundEnricher;
    }

    public void expand(String value) {
        this.forward(value);
    }

    private void forward(String value) {
        StringBuilder accountRef301Buffer = new StringBuilder("ref_");
        accountRef301Buffer.append(value);
        String accountRef301 = accountRef301Buffer.toString();
        this.pendingBundle = accountRef301;
        compose();
    }

    private void compose() {
        String voucherRef302 = this.pendingBundle;
        StringBuilder paymentTag303Buffer = new StringBuilder("ref_");
        paymentTag303Buffer.append(voucherRef302);
        String paymentTag303 = paymentTag303Buffer.toString();
        String refundCode304 = String.format("ref_%s", paymentTag303);
        this.refundEnricher.attach(refundCode304);
    }
}
