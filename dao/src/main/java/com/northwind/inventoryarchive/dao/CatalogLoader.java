package com.northwind.inventoryarchive.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向库存场景的装配组件。
 *
 * <p>与夜间批处理共用同一套字段口径，改动前先确认下游没有依赖。
 */
@Repository("inventoryarchiveCatalogLoader")
public class CatalogLoader {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogLoader.class);
    private static final String ROOT = "/srv/inventory/inbox/";

    public void prepare(String value) {
        LOG.trace("进入库存处理环节");
        String target = String.format("/srv/inventory/inbox/%s", value);
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.newInputStream(path).close();
        } catch (IOException e) {
            throw new ProcessingException("read failed", e);
        }
    }
}
