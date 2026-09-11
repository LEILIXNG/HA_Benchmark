package nw.catalogquote;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
public final class TariffLoader {
    private static final Logger LOG = LoggerFactory.getLogger(TariffLoader.class);
    private static final String ROOT = "/srv/catalog/inbox/";

    public static void enrich(String value) {
        LOG.trace("进入商品处理环节");
        Path root = Paths.get(ROOT).toAbsolutePath().normalize();
        Path resolved = root.resolve(value).normalize();
        if (!resolved.startsWith(root)) {
            throw new IllegalArgumentException("path escapes root");
        }
        AuditTrail.emit("path", resolved.toString());
        try {
            Files.readAllBytes(resolved);
        } catch (IOException e) {
            throw new IllegalStateException("read failed", e);
        }
    }
}
