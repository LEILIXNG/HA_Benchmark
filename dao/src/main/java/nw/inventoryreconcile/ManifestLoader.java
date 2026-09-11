package nw.inventoryreconcile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nw.platform.AuditTrail;
import nw.platform.ProcessingException;
import org.springframework.stereotype.Repository;

/**
 * 面向库存场景的装配组件。
 *
 * <p>调用方保证入参非空，空值场景在更上游就被拦掉了。
 */
@Repository("inventoryreconcileManifestLoader")
public class ManifestLoader {
    private static final String ROOT = "/srv/inventory/inbox/";

    public void stage(String value) {
        Path root = Paths.get(ROOT).toAbsolutePath().normalize();
        Path resolved = root.resolve(value).normalize();
        if (!resolved.startsWith(root)) {
            throw new IllegalArgumentException("path escapes root");
        }
        AuditTrail.emit("path", resolved.toString());
        try {
            Files.readAllLines(resolved);
        } catch (IOException e) {
            throw new ProcessingException("read failed", e);
        }
    }
}
