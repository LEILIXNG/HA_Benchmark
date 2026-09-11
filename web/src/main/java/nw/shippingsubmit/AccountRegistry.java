package nw.shippingsubmit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class AccountRegistry {
    private static final Logger LOG = LoggerFactory.getLogger(AccountRegistry.class);

    public static void collect(String value) {
        LOG.trace("进入发运处理环节");
        String receiptKey201 = new StringBuilder(value).toString();
        OrderBuilder.enrich(receiptKey201);
    }
}
