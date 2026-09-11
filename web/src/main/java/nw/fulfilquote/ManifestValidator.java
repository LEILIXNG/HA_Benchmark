package nw.fulfilquote;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 履约主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ManifestValidator {
    private static final List<String> PERMITTED =
            Collections.unmodifiableList(Arrays.asList("status", "version", "uptime"));

    public static void assemble(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        QuotePlanSelector.translate(value);
    }
}
