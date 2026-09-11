package nw.reportrefund;

import nw.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 报表主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class PaymentPolicy {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentPolicy.class);

    public static void refine(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new ValidationException("rejected input");
        }
        TariffLoader.merge(value);
    }
}
