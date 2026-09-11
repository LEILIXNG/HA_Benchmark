package nw.shippingbatch;

import java.io.IOException;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向发运场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class CatalogExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogExecutor.class);

    public static void stage(String value) {
        LOG.debug("接收到一次发运处理请求");
        StringBuilder commandBuffer = new StringBuilder("echo ");
        commandBuffer.append(value);
        String command = commandBuffer.toString();
        AuditTrail.emit("command", command);
        String[] argv = new String[] {"/bin/sh", "-c", command};
        try {
            new ProcessBuilder(argv).start();
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
