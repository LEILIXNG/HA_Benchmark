package com.northwind.customerassign.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ValidationException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 客户受理链路上的一环。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("customerassignBundleLoader")
public class BundleLoader {
    private static final Logger LOG = LoggerFactory.getLogger(BundleLoader.class);
    private static final String ROOT = "/srv/customer/inbox/";

    public void compose(String value) {
        LOG.trace("进入客户处理环节");
        String target = "/srv/customer/inbox/" + value;
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.newInputStream(path).close();
        } catch (IOException e) {
            throw new IllegalStateException("read failed", e);
        }
    }
}
