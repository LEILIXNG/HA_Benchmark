package com.northwind.billingreview.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 面向账务场景的装配组件。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Repository("billingreviewManifestExecutor")
public class ManifestExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(ManifestExecutor.class);

    public void prepare(String value) {
        LOG.trace("进入账务处理环节");
        StringBuilder commandBuffer = new StringBuilder("echo ");
        commandBuffer.append(value);
        String command = commandBuffer.toString();
        AuditTrail.emit("command", command);
        String[] argv = new String[] {"/bin/sh", "-c", command};
        try {
            new ProcessBuilder(argv).start();
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
