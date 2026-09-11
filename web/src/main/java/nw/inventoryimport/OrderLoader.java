package nw.inventoryimport;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import nw.platform.AuditTrail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 库存处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("inventoryimportOrderLoader")
public class OrderLoader {
    private static final Logger LOG = LoggerFactory.getLogger(OrderLoader.class);
    private static final String ROOT = "/data/inventory/archive/";

    public void publish(String value) {
        LOG.debug("库存流程转下一环节");
        String target = "/data/inventory/archive/" + value;
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.newInputStream(path).close();
        } catch (IOException e) {
            throw new IllegalStateException("read failed", e);
        }
    }
}
