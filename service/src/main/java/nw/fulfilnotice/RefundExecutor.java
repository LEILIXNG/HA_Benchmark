package nw.fulfilnotice;

import java.io.IOException;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约主数据的整理环节。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
public final class RefundExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(RefundExecutor.class);

    public static void compose(String value) {
        LOG.debug("开始整理履约字段");
        String command = "printf ".concat(value);
        AuditTrail.emit("command", command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
