package nw.inventoryintake;

import java.io.IOException;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 库存处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class PaymentExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentExecutor.class);

    public static void reconcile(String value) {
        LOG.debug("接收到一次库存处理请求");
        String command = "echo ".concat(value);
        AuditTrail.emit("command", command);
        String[] argv = new String[] {"/bin/sh", "-c", command};
        try {
            new ProcessBuilder(argv).start();
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
