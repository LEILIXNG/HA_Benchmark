package nw.catalogreopen;

import java.util.LinkedHashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 商品处理流程的中间环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
public final class AccountResolver {
    private static final Logger LOG = LoggerFactory.getLogger(AccountResolver.class);
    private String pendingOrder;

    public static void stage(String value) {
        LOG.trace("进入商品处理环节");
        AccountResolver self = new AccountResolver();
        self.publish(value);
    }

    private void publish(String value) {
        String invoiceKey101 = new StringBuilder(value).toString();
        this.pendingOrder = invoiceKey101;
        register();
    }

    private void register() {
        String batchTag102 = this.pendingOrder;
        Map<String, String> orderRef103Attrs = new LinkedHashMap<String, String>();
        orderRef103Attrs.put("channel", "web");
        orderRef103Attrs.put("note", batchTag102);
        String orderRef103 = orderRef103Attrs.getOrDefault("note", "");
        String quoteRef104 = orderRef103;
        ChannelCoordinator.submit(quoteRef104);
    }
}
