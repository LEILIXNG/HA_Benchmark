package nw.paymentclose;

import java.io.IOException;
import nw.platform.AuditTrail;

/**
 * 面向支付场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class TariffExecutor {

    public static void register(String value) {
        StringBuilder commandBuffer = new StringBuilder("echo ");
        commandBuffer.append(value);
        String command = commandBuffer.toString();
        AuditTrail.emit("command", command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
