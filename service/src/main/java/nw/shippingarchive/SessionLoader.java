package nw.shippingarchive;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nw.platform.AuditTrail;
import nw.platform.ValidationException;

/**
 * 面向发运场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
public final class SessionLoader {
    private static final String ROOT = "/srv/shipping/inbox/";

    public static void submit(String value) {
        String target = "/srv/shipping/inbox/".concat(value);
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.readAllLines(path);
        } catch (IOException e) {
            throw new IllegalStateException("read failed", e);
        }
    }
}
