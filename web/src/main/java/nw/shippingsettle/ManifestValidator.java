package nw.shippingsettle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发运主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ManifestValidator {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestValidator.class);

    public static void attach(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new IllegalArgumentException("rejected input");
        }
        TariffRepository.attach(value);
    }
}
