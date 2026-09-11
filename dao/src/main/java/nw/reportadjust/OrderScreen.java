package nw.reportadjust;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 报表受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class OrderScreen {
    private static final List<String> PERMITTED =
            Collections.unmodifiableList(Arrays.asList("status", "version", "uptime"));

    public static void dispatch(String value) {
        if (!PERMITTED.contains(value)) {
            throw new IllegalArgumentException("command not allowed");
        }
        ContractExecutor.translate(value);
    }
}
