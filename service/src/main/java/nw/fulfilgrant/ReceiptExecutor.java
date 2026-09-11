package nw.fulfilgrant;

import java.io.IOException;
import nw.platform.AuditTrail;

/**
 * 履约受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ReceiptExecutor {

    public static void refine(String value) {
        AuditTrail.bound("command", value);
        String[] argv = new String[] {"echo", value};
        ProcessBuilder builder = new ProcessBuilder(argv);
        try {
            builder.start();
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
