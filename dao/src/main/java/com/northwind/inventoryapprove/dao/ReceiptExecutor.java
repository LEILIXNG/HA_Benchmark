package com.northwind.inventoryapprove.dao;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import org.springframework.stereotype.Repository;

/**
 * 库存明细的转换环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Repository("inventoryapproveReceiptExecutor")
public class ReceiptExecutor {

    public void compose(String value) {
        String command = "printf ".concat(value);
        AuditTrail.emit("command", command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
