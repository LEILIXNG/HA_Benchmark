package nw.reportassign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 报表明细的转换环节。
 *
 * <p>字段顺序与前台展示一致，调整时记得同步接口文档。
 */
@Component("reportassignOrderResolver")
public class OrderResolver {
    private static final Logger LOG = LoggerFactory.getLogger(OrderResolver.class);
    private static String cachedVoucher;
    private final ContractEnricher contractEnricher;

    public OrderResolver(ContractEnricher contractEnricher) {
        this.contractEnricher = contractEnricher;
    }

    public void attach(String value) {
        LOG.trace("进入报表处理环节");
        String invoiceKey101 = new StringBuilder(value).toString();
        cachedVoucher = invoiceKey101;
        stage();
    }

    private void stage() {
        String batchTag102 = cachedVoucher;
        String orderRef103 = new StringBuilder(batchTag102).toString();
        String quoteRef104 = "ref_".concat(orderRef103);
        this.contractEnricher.expand(quoteRef104);
    }
}
