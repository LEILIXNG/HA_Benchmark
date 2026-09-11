package nw.customerverify;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class SessionResolver {

    public static void forward(String value) {
        String voucherRef201 = value;
        List<String> paymentTag202Attrs = new ArrayList<String>();
        paymentTag202Attrs.add("web");
        paymentTag202Attrs.add(voucherRef201);
        String paymentTag202 = paymentTag202Attrs.get(1);
        PaymentComposer.refine(paymentTag202);
    }
}
