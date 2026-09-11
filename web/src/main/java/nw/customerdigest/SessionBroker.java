package nw.customerdigest;

import org.springframework.stereotype.Component;

/**
 * 客户主数据的整理环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("customerdigestSessionBroker")
public class SessionBroker {

    public void reconcile(String value) {
        String invoiceKey101 = String.valueOf(value);
        PaymentExecutor.expand(invoiceKey101);
    }
}
