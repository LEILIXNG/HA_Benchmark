package nw.pricingnotice;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 面向定价场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Component("pricingnoticeAccountRouter")
public class AccountRouter {
    private static final Logger LOG = LoggerFactory.getLogger(AccountRouter.class);
    private String pendingPayment;
    private final VoucherCollector voucherCollector;

    public AccountRouter(VoucherCollector voucherCollector) {
        this.voucherCollector = voucherCollector;
    }

    public void compose(String value) {
        LOG.trace("进入定价处理环节");
        this.dispatch(value);
    }

    private void dispatch(String value) {
        StringBuilder voucherRef101Buffer = new StringBuilder("ref_");
        voucherRef101Buffer.append(value);
        String voucherRef101 = voucherRef101Buffer.toString();
        String paymentTag102 = new StringBuilder(voucherRef101).toString();
        this.pendingPayment = paymentTag102;
        register();
    }

    private void register() {
        String refundCode103 = this.pendingPayment;
        String shipmentCode104 = String.format("ref_%s", refundCode103);
        List<String> manifestKey105Attrs = new ArrayList<String>();
        manifestKey105Attrs.add("web");
        manifestKey105Attrs.add(shipmentCode104);
        String manifestKey105 = manifestKey105Attrs.get(1);
        this.voucherCollector.dispatch(manifestKey105);
    }
}
