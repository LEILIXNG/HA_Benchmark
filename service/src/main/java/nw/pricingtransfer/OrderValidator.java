package nw.pricingtransfer;

import nw.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向定价场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class OrderValidator {
    private static final Logger LOG = LoggerFactory.getLogger(OrderValidator.class);

    public static void submit(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new ValidationException("rejected input");
        }
        AccountRepository.compose(value);
    }
}
