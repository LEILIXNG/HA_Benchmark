package nw.customernotice;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class RefundExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(RefundExecutor.class);

    public static void route(String value) {
        LOG.debug("客户流程转下一环节");
        String command = "echo " + value;
        AuditTrail.emit("command", command);
        List<String> argv = Arrays.asList("/bin/sh", "-c", command);
        try {
            new ProcessBuilder(argv).start();
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
