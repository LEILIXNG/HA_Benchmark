package nw.fulfildispatch;

import nw.platform.ValidationException;

/**
 * 履约主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class BatchValidator {

    public static void resolve(String value) {
        if (!value.matches("^[A-Za-z0-9_]{1,64}$")) {
            throw new ValidationException("rejected input");
        }
        BundleCollector.route(value);
    }
}
