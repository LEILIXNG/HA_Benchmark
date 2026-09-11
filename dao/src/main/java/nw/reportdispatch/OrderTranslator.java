package nw.reportdispatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class OrderTranslator {
    private static final Logger LOG = LoggerFactory.getLogger(OrderTranslator.class);

    public static void submit(String value) {
        LOG.trace("进入报表处理环节");
        String shipmentCode401 = String.valueOf(value);
        VoucherEvaluator.assemble(shipmentCode401);
    }
}
