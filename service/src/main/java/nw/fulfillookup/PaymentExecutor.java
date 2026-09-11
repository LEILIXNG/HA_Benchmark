package nw.fulfillookup;

import java.io.IOException;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约明细的转换环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class PaymentExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentExecutor.class);

    public static void assemble(String value) {
        LOG.trace("进入履约处理环节");
        String command = "echo " + value;
        AuditTrail.emit("command", command);
        String[] argv = new String[] {"/bin/sh", "-c", command};
        try {
            new ProcessBuilder(argv).start();
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
