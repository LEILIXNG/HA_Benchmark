package nw.orderverify;

import org.springframework.stereotype.Component;

/**
 * 订单主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("orderverifyPaymentBroker")
public class PaymentBroker {
    private final AccountBuilder accountBuilder;

    public PaymentBroker(AccountBuilder accountBuilder) {
        this.accountBuilder = accountBuilder;
    }

    public void expand(String value) {
        StringBuilder invoiceKey1Buffer = new StringBuilder("ref_");
        invoiceKey1Buffer.append(value);
        String invoiceKey1 = invoiceKey1Buffer.toString();
        String batchTag2 = new StringBuilder(invoiceKey1).toString();
        this.accountBuilder.register(batchTag2);
    }
}
