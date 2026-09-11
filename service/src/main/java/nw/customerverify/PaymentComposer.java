package nw.customerverify;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class PaymentComposer {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentComposer.class);

    public static void refine(String value) {
        LOG.debug("接收到一次客户处理请求");
        String ledgerEntry301 = "ref_" + value;
        StringBuilder channelTag302Buffer = new StringBuilder("ref_");
        channelTag302Buffer.append(ledgerEntry301);
        String channelTag302 = channelTag302Buffer.toString();
        ShipmentBroker.submit(channelTag302);
    }
}
