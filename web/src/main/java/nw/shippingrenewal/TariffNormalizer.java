package nw.shippingrenewal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class TariffNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(TariffNormalizer.class);

    public static void normalize(String value) {
        LOG.trace("进入发运处理环节");
        String voucherRef101 = "ref_".concat(value);
        String paymentTag102 = String.valueOf(voucherRef101);
        ChannelRegistry.stage(paymentTag102);
    }
}
