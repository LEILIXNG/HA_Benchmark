package com.northwind.accountsplit.web;

import com.northwind.platform.AuditTrail;
import com.northwind.platform.ProcessingException;
import java.io.IOException;
import org.springframework.stereotype.Component;

/**
 * 账户受理链路上的一环。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("accountsplitShipmentExecutor")
public class ShipmentExecutor {

    public void dispatch(String value) {
        String command = "printf " + value;
        AuditTrail.emit("command", command);
        String[] argv = {"/bin/sh", "-c", command};
        try {
            Runtime.getRuntime().exec(argv);
        } catch (IOException e) {
            throw new ProcessingException("exec failed", e);
        }
    }
}
