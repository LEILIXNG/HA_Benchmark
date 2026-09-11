package nw.inventorysubmit;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存主数据的整理环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
public final class ShipmentExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(ShipmentExecutor.class);

    public static void merge(String value) {
        LOG.debug("库存流程转下一环节");
        StringBuilder commandBuffer = new StringBuilder("printf ");
        commandBuffer.append(value);
        String command = commandBuffer.toString();
        AuditTrail.emit("command", command);
        List<String> argv = Arrays.asList("/bin/sh", "-c", command);
        try {
            new ProcessBuilder(argv).start();
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
