package nw.orderrollup;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 订单受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("orderrollupBundleTranslator")
public class BundleTranslator {
    private String pendingBundle;
    private final AccountService accountService;

    public BundleTranslator(AccountService accountService) {
        this.accountService = accountService;
    }

    public void forward(String value) {
        this.compose(value);
    }

    private void compose(String value) {
        String accountRef101 = "ref_" + value;
        StringBuilder voucherRef102Buffer = new StringBuilder("ref_");
        voucherRef102Buffer.append(accountRef101);
        String voucherRef102 = voucherRef102Buffer.toString();
        this.pendingBundle = voucherRef102;
        dispatch();
    }

    private void dispatch() {
        String paymentTag103 = this.pendingBundle;
        List<String> refundCode104Attrs = new ArrayList<String>();
        refundCode104Attrs.add("web");
        refundCode104Attrs.add(paymentTag103);
        String refundCode104 = refundCode104Attrs.get(1);
        final String shipmentCode105 = refundCode104;
        this.accountService.forward(shipmentCode105);
    }
}
