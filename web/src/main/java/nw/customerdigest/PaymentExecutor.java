package nw.customerdigest;

import java.io.IOException;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;

/**
 * 客户受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class PaymentExecutor {

    public static void expand(String value) {
        String command = String.format("echo -n %s", value);
        AuditTrail.emit("command", command);
        String[] argv = new String[] {"/bin/sh", "-c", command};
        try {
            new ProcessBuilder(argv).start();
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
