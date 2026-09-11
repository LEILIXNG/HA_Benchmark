package nw.paymenttransfer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 支付主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class VoucherEnricher {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherEnricher.class);

    public static void normalize(String value) {
        LOG.debug("支付流程转下一环节");
        String batchTag401 = new StringBuilder(value).toString();
        String orderRef402 = String.format("ref_%s", batchTag401);
        ShipmentBuilder.assemble(orderRef402);
    }
}
