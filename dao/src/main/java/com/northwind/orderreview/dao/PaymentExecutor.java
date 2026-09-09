package com.northwind.orderreview.dao;

import com.northwind.platform.AuditTrail;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 订单处理流程的中间环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Repository("orderreviewPaymentExecutor")
public class PaymentExecutor {
    private static final Logger LOG = LoggerFactory.getLogger(PaymentExecutor.class);

    public void normalize(String value) {
        LOG.debug("接收到一次订单处理请求");
        String command = "echo -n " + value;
        AuditTrail.emit("command", command);
        String[] argv = new String[] {"/bin/sh", "-c", command};
        try {
            new ProcessBuilder(argv).start();
        } catch (IOException e) {
            throw new IllegalStateException("exec failed", e);
        }
    }
}
