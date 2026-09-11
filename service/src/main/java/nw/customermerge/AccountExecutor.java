package nw.customermerge;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import nw.platform.AuditTrail;

/**
 * 客户明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class AccountExecutor {

    public static void normalize(String value) {
        String command = "echo -n " + value;
        AuditTrail.emit("command", command);
        List<String> argv = Arrays.asList("/bin/sh", "-c", command);
        try {
            new ProcessBuilder(argv).start();
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
