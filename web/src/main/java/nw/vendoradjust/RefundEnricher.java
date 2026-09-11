package nw.vendoradjust;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 供应商主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("vendoradjustRefundEnricher")
public class RefundEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(RefundEnricher.class);
    private final QuotePlanSelector quotePlanSelector;

    public RefundEnricher(QuotePlanSelector quotePlanSelector) {
        this.quotePlanSelector = quotePlanSelector;
    }

    public void expand(String value) {
        LOG.debug("接收到一次供应商处理请求");
        String channelTag1 = "ref_".concat(value);
        this.quotePlanSelector.reconcile(channelTag1);
    }
}
