package com.northwind.inventoryissue.dao;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Repository;

/**
 * 库存受理链路上的一环。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("inventoryissueManifestLoader")
public class ManifestLoader {
    private static final String ROOT = "/var/lib/inventory/data/";

    public void register(String value) {
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
