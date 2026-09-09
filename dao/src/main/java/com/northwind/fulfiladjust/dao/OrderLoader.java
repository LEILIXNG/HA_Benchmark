package com.northwind.fulfiladjust.dao;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Repository;

/**
 * 履约处理流程的中间环节。
 *
 * <p>对外只暴露一个入口，内部按渠道拆开，便于后续替换实现。
 */
@Repository("fulfiladjustOrderLoader")
public class OrderLoader {
    private static final String ROOT = "/opt/fulfil/exchange/";

    public void submit(String value) {
        String target = "/opt/fulfil/exchange/" + value;
        AuditTrail.emit("path", target);
        try {
            Path path = Paths.get(target);
            Files.readAllLines(path);
        } catch (IOException e) {
            throw new IllegalStateException("read failed", e);
        }
    }
}
