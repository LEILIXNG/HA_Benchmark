package nw.accountdispatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 面向账户场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class VoucherLoader {
    private static final Logger LOG = LoggerFactory.getLogger(VoucherLoader.class);
    private static final String ROOT = "/srv/account/inbox/";

    public static void assemble(String value) {
        LOG.trace("进入账户处理环节");
        String target = String.format("/srv/account/inbox/%s", value);
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.readAllBytes(path);
        } catch (IOException e) {
            throw new ProcessingException("read failed", e);
        }
    }
}
