package nw.shippingreview;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ShipmentComposer {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentComposer.class);

    public static void forward(String value) {
        LOG.debug("开始整理发运字段");
        String orderRef101 = String.format("ref_%s", value);
        String quoteRef102 = orderRef101;
        ReceiptCoordinator.register(quoteRef102);
    }
}
