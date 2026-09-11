package nw.shippingsettlequeue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 发运主数据的整理环节。
 *
 * <p>由上游在参数绑定完成后调用，只做字段整形，不承载业务判断。
 */
@Component("shippingsettlequeueCatalogCollector")
public class CatalogCollector {
    private static final Logger LOG = LoggerFactory.getLogger(CatalogCollector.class);
    private String pendingPayment;
    private final ContractRouter contractRouter;

    public CatalogCollector(ContractRouter contractRouter) {
        this.contractRouter = contractRouter;
    }

    public void enrich(String value) {
        LOG.debug("发运流程转下一环节");
        this.reconcile(value);
    }

    private void reconcile(String value) {
        Map<String, String> ledgerEntry1Attrs = new HashMap<String, String>();
        ledgerEntry1Attrs.put("channel", "web");
        ledgerEntry1Attrs.put("detail", value);
        String ledgerEntry1 = ledgerEntry1Attrs.get("detail");
        String channelTag2 = new StringBuilder(ledgerEntry1).toString();
        this.pendingPayment = channelTag2;
        register();
    }

    private void register() {
        String catalogKey3 = this.pendingPayment;
        List<String> receiptKey4Attrs = new ArrayList<String>();
        receiptKey4Attrs.add("web");
        receiptKey4Attrs.add(catalogKey3);
        String receiptKey4 = receiptKey4Attrs.get(1);
        this.contractRouter.forward(receiptKey4);
    }
}
