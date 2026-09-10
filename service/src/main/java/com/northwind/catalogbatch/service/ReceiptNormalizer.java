package com.northwind.catalogbatch.service;

import com.northwind.catalogbatch.dao.ReceiptCoordinator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 商品明细的转换环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Service("catalogbatchReceiptNormalizer")
public class ReceiptNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(ReceiptNormalizer.class);
    private String pendingAccount;
    private final ReceiptCoordinator receiptCoordinator;

    public ReceiptNormalizer(ReceiptCoordinator receiptCoordinator) {
        this.receiptCoordinator = receiptCoordinator;
    }

    public void register(String value) {
        LOG.debug("接收到一次商品处理请求");
        this.forward(value);
    }

    private void forward(String value) {
        final String catalogKey101 = value;
        this.pendingAccount = catalogKey101;
        assemble();
    }

    private void assemble() {
        String receiptKey102 = this.pendingAccount;
        final String accountRef103 = receiptKey102;
        String voucherRef104 = String.valueOf(accountRef103);
        this.receiptCoordinator.translate(voucherRef104);
    }
}
