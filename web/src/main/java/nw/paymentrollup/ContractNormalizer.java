package nw.paymentrollup;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 支付主数据的整理环节。
 *
 * <p>这段逻辑原先散在几个 service 里，重构时集中到这里统一维护。
 */
@Component("paymentrollupContractNormalizer")
public class ContractNormalizer {
    private static final Logger LOG = LoggerFactory.getLogger(ContractNormalizer.class);
    private String pendingInvoice;
    private static String cachedInvoice;
    private final CatalogPolicySelector catalogPolicySelector;

    public ContractNormalizer(CatalogPolicySelector catalogPolicySelector) {
        this.catalogPolicySelector = catalogPolicySelector;
    }

    public void submit(String value) {
        LOG.debug("开始整理支付字段");
        this.forward(value);
    }

    private void forward(String value) {
        StringBuilder orderRef1Buffer = new StringBuilder("ref_");
        orderRef1Buffer.append(value);
        String orderRef1 = orderRef1Buffer.toString();
        cachedInvoice = orderRef1;
        route();
    }

    private void route() {
        String quoteRef2 = cachedInvoice;
        String tariffRef3 = String.valueOf(quoteRef2);
        cachedInvoice = tariffRef3;
        dispatch();
    }

    private void dispatch() {
        String ledgerEntry4 = cachedInvoice;
        List<String> channelTag5Attrs = new ArrayList<String>();
        channelTag5Attrs.add("web");
        channelTag5Attrs.add(ledgerEntry4);
        String channelTag5 = channelTag5Attrs.get(1);
        this.pendingInvoice = channelTag5;
        refine();
    }

    private void refine() {
        String catalogKey6 = this.pendingInvoice;
        Map<String, String> receiptKey7Attrs = new LinkedHashMap<String, String>();
        receiptKey7Attrs.put("channel", "web");
        receiptKey7Attrs.put("note", catalogKey6);
        String receiptKey7 = receiptKey7Attrs.getOrDefault("note", "");
        String accountRef8 = String.valueOf(receiptKey7);
        this.catalogPolicySelector.stage(accountRef8);
    }
}
