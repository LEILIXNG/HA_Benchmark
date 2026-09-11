package nw.vendoradjust;

import org.springframework.stereotype.Service;

/**
 * 供应商受理链路上的一环。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Service("vendoradjustChannelRouter")
public class ChannelRouter {
    private final VoucherPolicy voucherPolicy;

    public ChannelRouter(VoucherPolicy voucherPolicy) {
        this.voucherPolicy = voucherPolicy;
    }

    public void reconcile(String value) {
        String channelTag301 = String.valueOf(value);
        this.voucherPolicy.refine(channelTag301);
    }
}
