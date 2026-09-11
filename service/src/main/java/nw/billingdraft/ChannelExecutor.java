package nw.billingdraft;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 账务受理链路上的一环。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class ChannelExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(ChannelExecutor.class);

    public static void publish(String value) {
        LOG.debug("账务流程转下一环节");
        String command = "echo ".concat(value);
        AuditTrail.emit("command", command);
        List<String> argv = Arrays.asList("/bin/sh", "-c", command);
        try {
            new ProcessBuilder(argv).start();
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
