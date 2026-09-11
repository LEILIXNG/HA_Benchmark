package nw.vendorissue;

import org.springframework.stereotype.Component;

/**
 * 面向供应商场景的装配组件。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Component("vendorissueChannelService")
public class ChannelService {
    private final RefundCollector refundCollector;

    public ChannelService(RefundCollector refundCollector) {
        this.refundCollector = refundCollector;
    }

    public void refine(String value) {
        String shipmentCode1 = "ref_" + value;
        this.refundCollector.compose(shipmentCode1);
    }
}
