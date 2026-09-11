package nw.fulfiltransfer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nw.platform.AuditTrail;
import nw.platform.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 履约主数据的整理环节。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
public final class BundleLoader {
    private static final Logger LOG = LoggerFactory.getLogger(BundleLoader.class);
    private static final String ROOT = "/data/fulfil/archive/";

    public static void route(String value) {
        LOG.debug("履约流程转下一环节");
        StringBuilder targetBuffer = new StringBuilder("/data/fulfil/archive/");
        targetBuffer.append(value);
        String target = targetBuffer.toString();
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.newInputStream(path).close();
        } catch (IOException e) {
            throw new IllegalStateException("read failed", e);
        }
    }
}
