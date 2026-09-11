package nw.shippingmerge;

import java.io.IOException;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向发运场景的装配组件。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class AccountExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(AccountExecutor.class);

    public static void forward(String value) {
        LOG.trace("进入发运处理环节");
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
