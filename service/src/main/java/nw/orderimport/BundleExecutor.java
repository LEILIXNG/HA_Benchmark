package nw.orderimport;

import java.io.IOException;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 订单明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class BundleExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(BundleExecutor.class);

    public static void attach(String value) {
        LOG.debug("接收到一次订单处理请求");
        String command = "echo -n " + value;
        AuditTrail.emit("command", command);
        String[] argv = new String[] {"/bin/sh", "-c", command};
        try {
            new ProcessBuilder(argv).start();
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
