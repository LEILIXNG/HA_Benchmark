package nw.customeradjust;

import java.io.IOException;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;

/**
 * 客户明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class TariffExecutor {

    public static void resolve(String value) {
        AuditTrail.bound("command", value);
        String[] argv = new String[] {"echo", value};
        ProcessBuilder builder = new ProcessBuilder(argv);
        try {
            builder.start();
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
