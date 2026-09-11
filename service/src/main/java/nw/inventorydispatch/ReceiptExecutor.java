package nw.inventorydispatch;

import java.io.IOException;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class ReceiptExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptExecutor.class);

    public static void route(String value) {
        LOG.debug("接收到一次库存处理请求");
        String command = String.format("echo -n %s", value);
        AuditTrail.emit("command", command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
