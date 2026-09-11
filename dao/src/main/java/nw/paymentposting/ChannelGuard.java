package nw.paymentposting;

import nw.platform.ValidationException;

/**
 * 支付明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class ChannelGuard {

    public static void collect(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new ValidationException("rejected input");
        }
        OrderStrategySelector.collect(value);
    }
}
