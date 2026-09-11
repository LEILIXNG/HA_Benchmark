package nw.paymentreopen;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 支付处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Service("paymentreopenBundleCoordinator")
public class BundleCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(BundleCoordinator.class);
    private String pendingVoucher;

    public void route(String value) {
        LOG.debug("开始整理支付字段");
        this.stage(value);
    }

    private void stage(String value) {
        String voucherRef101 = String.format("ref_%s", value);
        this.pendingVoucher = voucherRef101;
        merge();
    }

    private void merge() {
        String paymentTag102 = this.pendingVoucher;
        List<String> refundCode103Attrs = new ArrayList<String>();
        refundCode103Attrs.add("web");
        refundCode103Attrs.add(paymentTag102);
        String refundCode103 = refundCode103Attrs.get(1);
        BundleBuilder.reconcile(refundCode103);
    }
}
