package com.northwind.catalogrollup.web;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 商品主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("catalogrollupContractExecutor")
public class ContractExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(ContractExecutor.class);

    public void prepare(String value) {
        LOG.trace("进入商品处理环节");
        String command = "echo ".concat(value);
        AuditTrail.emit("command", command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
