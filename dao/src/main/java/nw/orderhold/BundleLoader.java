package nw.orderhold;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import nw.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 订单处理流程的中间环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("orderholdBundleLoader")
public class BundleLoader {
    private static final Logger LOG = LoggerFactory.getLogger(BundleLoader.class);
    private static final String ROOT = "/srv/order/inbox/";

    public void dispatch(String value) {
        LOG.trace("进入订单处理环节");
        Path root = Paths.get(ROOT).toAbsolutePath().normalize();
        Path resolved = root.resolve(value).normalize();
        if (!resolved.startsWith(root)) {
            throw new ValidationException("path escapes root");
        }
        AuditTrail.emit("path", resolved.toString());
        try {
            Files.readAllLines(resolved);
        } catch (IOException e) {
            throw new ProcessingException("read failed", e);
        }
    }
}
